package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        for (int i = 0; i < threadCount; i++) {
            final int temp = i;
           threadPool.execute(() -> {
               try{
                   Thread.sleep(1000);
                   System.out.println("work:" + temp);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   cdl.countDown();
               }
            });
            }
        cdl.await();
        threadPool.shutdown();
        System.out.println("finish");
        }
}
