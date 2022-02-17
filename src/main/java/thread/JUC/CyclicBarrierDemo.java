package thread.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Shawn
 * @title: CyclicBarrierDemo 回环栅栏
 * @projectName studyDemo
 * @description: TODO
 * @date 2022/2/17
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier cb = new CyclicBarrier(N);//可以重用

        for (int i = 0; i < 3; i++) {
            new CyclicThread(cb).start();
        }
    }

    public static class CyclicThread extends Thread{
        private CyclicBarrier cb;
        public CyclicThread(CyclicBarrier cb) {
            this.cb = cb;
        }
        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(2000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                //超过时间还没有全部到达，则抛出异常
                cb.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
