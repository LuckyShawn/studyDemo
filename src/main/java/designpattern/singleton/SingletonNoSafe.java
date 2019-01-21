package designpattern.singleton;

/**
 * @Description 单例模式：线程不安全的懒汉模式
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public class SingletonNoSafe {
    private static SingletonNoSafe singletonNoSafe;
    private SingletonNoSafe(){}

    public static synchronized SingletonNoSafe getInstance(){
        if(singletonNoSafe == null){
            singletonNoSafe = new SingletonNoSafe();
        }
        return singletonNoSafe;
    }
}
