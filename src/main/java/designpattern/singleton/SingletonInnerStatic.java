package designpattern.singleton;

/**
 * @Description 静态内部类实现单例模式
 * 线程安全，调用效率高，并且实现了延迟加载
 * @Author shawn
 * @create 2019/3/4 0004
 */
public class SingletonInnerStatic {

    private static class SingletonInnerStaticInstance{
        private static final SingletonInnerStatic instance = new SingletonInnerStatic();
    }

    private SingletonInnerStatic(){

    }

    public static SingletonInnerStatic getInstance(){
        return SingletonInnerStaticInstance.instance;
    }
}
