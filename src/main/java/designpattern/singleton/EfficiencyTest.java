package designpattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 效率测试
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class EfficiencyTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 9999999 ; i++) {
                    Object o = SingletonSafe.getInstance();   //饿汉式：15  16
                    //Object o = SingletonNoSafe.getInstance();   //懒汉式：393  4027
                    //Object o = SingletonSafeDouble.getInstance();   //双重检查：388 3920
                    //Object o = SingletonInnerStatic.getInstance();//静态内部类：21  17
                    //Object o = SingletonEnum.INSTANCE;  //枚举：22  15
                }
                countDownLatch.countDown(); //计数-1
            }
        }).start();
        }
        countDownLatch.await(); //main线程阻塞，直到计数器变为0，才往下执行
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start));
    }
}
