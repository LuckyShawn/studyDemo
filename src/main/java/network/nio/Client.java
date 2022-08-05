package network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author Shawn
 * @title: Client
 * @projectName studyDemo
 * @description: TODO
 * @date 2022/3/30
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8080));
        SocketAddress address = sc.getLocalAddress();
        System.out.println(address.toString());
        System.out.println("waiting...");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        sc.write(Charset.defaultCharset().encode("nihao!"));
    }
}
