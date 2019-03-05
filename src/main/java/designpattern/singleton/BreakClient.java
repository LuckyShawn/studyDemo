package designpattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description 破解单例模式（懒汉式），枚举方式无法破解
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class BreakClient {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        //通过反射破解，调用私有构造器
        Class<SingletonBreak> clazz = (Class<SingletonBreak>) Class.forName("designpattern.singleton.SingletonBreak");
        Constructor<SingletonBreak> con = clazz.getDeclaredConstructor(null);
        con.setAccessible(true);
        SingletonBreak s1 = con.newInstance();
        SingletonBreak s2 = con.newInstance();
        System.out.println(s1);//designpattern.singleton.SingletonBreak@1761e840
        System.out.println(s2);//designpattern.singleton.SingletonBreak@6c629d6e
        //输出了两个不同的对象，破坏了单例模式


        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("F:/DemoWork/studyDemo/src/main/java/designpattern/singleton/Break.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();
        SingletonBreak s = SingletonBreak.getInstance();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:/DemoWork/studyDemo/src/main/java/designpattern/singleton/Break.txt"));
        SingletonBreak s3 = (SingletonBreak) ois.readObject();
        System.out.println(s);
        System.out.println(s3);
//        designpattern.singleton.SingletonBreak@1761e840
//        designpattern.singleton.SingletonBreak@6c629d6e
//        designpattern.singleton.SingletonBreak@3567135c
        //通过结果可以看出三个对象都是不相同的。
    }
}
