package designpattern.singleton;

/**
 * @Description 单例模式：线程不安全的懒汉模式
 * 资源利用率高，并发效率低
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public class SingletonNoSafe {
    private static SingletonNoSafe singletonNoSafe;
    private SingletonNoSafe(){}

    //方法同步，影响效率，若不加synchronized会有线程安全问题，可能会创建两个实例
    public static synchronized SingletonNoSafe getInstance(){
        if(singletonNoSafe == null){
            singletonNoSafe = new SingletonNoSafe();
        }
        return singletonNoSafe;
    }
}
