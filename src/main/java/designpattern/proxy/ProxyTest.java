package designpattern.proxy;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class ProxyTest {
    public static void main(String[] args){
        Image image = new ProxyImage("123.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
