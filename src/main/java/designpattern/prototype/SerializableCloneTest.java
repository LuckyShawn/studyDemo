package designpattern.prototype;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class SerializableCloneTest {
    public static void main(String[] args)throws Exception{
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1997-01-01");
        Sheep s1 = new Sheep("少利",date);
        System.out.println(s1);

        //实现序列化和反序列化实现克隆
        //ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileOutputStream fos = new FileOutputStream("F:/DemoWork/studyDemo/src/main/java/designpattern/prototype/SheepData");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);

        FileInputStream fis = new FileInputStream("F:/DemoWork/studyDemo/src/main/java/designpattern/prototype/SheepData");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Sheep s2 = (Sheep) ois.readObject();
        System.out.println(s2);
        date.setTime(1000000000000L);    //改变引用指向的对象
        System.out.println(date);
        System.out.println(s2);


    }
}
