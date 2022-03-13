package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Shawn
 * @title: ThreadPool
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/11/2
 */
public class ThreadPool {
    public static void main(String[] args) {
        //创建一个可重用固定线程的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3= new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.shutdown();
    }
}
