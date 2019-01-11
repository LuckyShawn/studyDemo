package designpattern;

/**
 * @Description 单例模式:线程安全的饿汉模式
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public class SingletonSafe {
    public static SingletonSafe singletonSafe = new SingletonSafe();
    private SingletonSafe(){}

    private static SingletonSafe getInstance(){

        return singletonSafe;
    }
}
