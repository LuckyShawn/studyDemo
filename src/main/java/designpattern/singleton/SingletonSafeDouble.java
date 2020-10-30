package designpattern.singleton;

/**
 * @Description 单例模式：双重校验模式 只需要第一次创建实例需要同步
 * 由于编译器优化原因和JVM底层模型原因，偶尔会出现问题，所以不建议使用
 *
 * 问题位置：在new对象时，分为三步:1.分配对象的内存空间 2.初始化对象 3.设置sInstance指向刚分配的内存地址
 * 编译器可能会将步骤2和3指令重排，导致在对象还没有进行初始化时，其他线程刚好到位置1，判断对象是非空，但是返回的却是一个未初始化的对象，导致异常
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public class SingletonSafeDouble {
    private volatile static SingletonSafeDouble singletonSafeDouble;    //加入volatile禁止指令重排序

    private SingletonSafeDouble(){}

    public synchronized static SingletonSafeDouble getInstance(){
        if(singletonSafeDouble == null){ //位置1
            synchronized (SingletonSafeDouble.class){
                if(singletonSafeDouble == null) {
                    singletonSafeDouble = new SingletonSafeDouble();  //问题位置2
                }
            }
        }

        return singletonSafeDouble;
    }
}
