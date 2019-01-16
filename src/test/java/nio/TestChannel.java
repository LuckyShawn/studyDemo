package nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 *
 * @Author shawn
 * @create 2019/1/16 0016
 * @Description
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 *
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 *
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 *
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 *
 */
public class TestChannel {
    public String inPath = "F:/DemoWork/studyDemo/src/main/resources/nio.zip";
    public String outPath = "F:/DemoWork/studyDemo/src/main/resources/Copy_nio.zip";


    @Test
    public void test6() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");

        //编码器
        CharsetEncoder encoder = cs1.newEncoder();

        //解码器
        CharsetDecoder decoder = cs1.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("你好Java!");
        charBuffer.flip();

        //编码
        ByteBuffer byteBuffer = encoder.encode(charBuffer);
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println(byteBuffer.get());
        }

        byteBuffer.flip();
        CharBuffer charBuffer1 = decoder.decode(byteBuffer);
        System.out.println(charBuffer1.toString());

        System.out.println("---------------------");
        //不同的编码格式解码
        byteBuffer.flip();
        Charset cs2 = Charset.forName("UTF-8");
        CharBuffer cBuf3 = cs2.decode(byteBuffer);
        System.out.println(cBuf3.toString());

    }


    //支持的字符集
    @Test
    public void test5(){
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Entry<String, Charset>> set = map.entrySet();

        for (Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }


    //分散和聚集
    @Test
    public void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("F:/DemoWork/studyDemo/src/main/resources/1.txt", "rw");

        //1. 获取通道
        FileChannel fileChannel = raf1.getChannel();

        //2. 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(100);
        ByteBuffer buffer1 = ByteBuffer.allocate(1000);

        //3. 分散读取
        ByteBuffer[] buffers = {buffer,buffer1};
        fileChannel.read(buffers);

        for (ByteBuffer byteBuffer : buffers) {
            byteBuffer.flip();
        }
        System.out.println(new String(buffers[0].array(),0,buffers[0].limit()));
        System.out.println("-----------------");
        System.out.println(new String(buffers[1].array(),0,buffers[1].limit()));


        //4. 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("F:/DemoWork/studyDemo/src/main/resources/2.txt","rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(buffers);
    }


    //通道之间的数据传输(直接缓冲区)
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get(inPath), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(outPath), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

//		inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    //使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws IOException { //耗费时间为：1647
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get(inPath), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(outPath), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));
    }


    //利用通道完成文件的复制（非直接缓冲区）
    @Test
    public void test1(){ //耗费时间为：20254
        Long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        //①获取通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis =  new FileInputStream(inPath);
            fos = new FileOutputStream(outPath);
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            //②分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(inChannel.read(buffer) != -1){
                buffer.flip(); //切换读取数据的模式
                //④将缓冲区中的数据写入通道中
                outChannel.write(buffer);
                buffer.clear(); //清空缓冲区
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));
    }
}
