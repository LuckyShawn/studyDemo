package thread.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Shawn
 * @title: CountDownLunchDemo
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/3/30
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
