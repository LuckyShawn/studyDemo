package designpattern.singleton;

/**
 * @Description 单例模式：双重校验模式 只需要第一次创建实例需要同步
 * 由于编译器优化原因和JVM底层模型原因，偶尔会出现问题，所以不建议使用
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public class SingletonSafeDouble {
    private volatile static SingletonSafeDouble singletonSafeDouble;

    private SingletonSafeDouble(){

    }

    public synchronized static SingletonSafeDouble singletonSafeDouble(){
        if(singletonSafeDouble == null){
            synchronized (SingletonSafeDouble.class){
                if(singletonSafeDouble == null) {
                    singletonSafeDouble = new SingletonSafeDouble();
                }
            }
        }

        return singletonSafeDouble;
    }
}
