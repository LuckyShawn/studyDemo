package designpattern.singleton;

/**
 * @Description 单例模式:线程安全的饿汉模式
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public class SingletonSafe {
    private static SingletonSafe singletonSafe = new SingletonSafe();
    private SingletonSafe(){}

    //方法没有同步，调用效率高
    public static SingletonSafe getInstance(){

        return singletonSafe;
    }
}
