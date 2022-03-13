package thread.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Shawn
 * @title: CountDownLunchDemo 计数器
 * @projectName studyDemo
 * @description: 减法计数，先设置一个固定数比如count=6，线程每执行一次减1，直到count=0释放所有线程
 * 调用countDown()方法计数减1
 * 计数为0时，释放所有等待的线程，无法重置
 * 调用await()方法只进行阻塞，对计数没任何影响
 * 不可重复利用
 * @date 2022/2/17
 */
public class CountDownLunchDemo {

    private static final int threadCount = 6;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        final CountDownLatch cdl = new CountDownLatch(threadCount);
        for (int i = 0; i < 6; i++) {
            final int temp = i;
           threadPool.execute(() -> {
               try{
                   Thread.sleep(1000 * temp);
                   System.out.println("work:" + temp);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   cdl.countDown();
               }
            });
            }
        try {
            //如果3秒过了其他线程还没有执行完，则直接往后执行
            cdl.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw e;
        }finally{
            threadPool.shutdown();
        }
        System.out.println("finish");
        }
}
