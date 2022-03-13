package thread.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Shawn
 * @title: MainWork
 * @projectName studyDemo
 * @description: TODO
 * @date 2022/1/13
 */
public class MainWork {
    public static void main(String[] args) throws InterruptedException {
        //创建一个可重用固定线程的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        System.out.println("开始分配");
        AsyncWork asyncWork = new AsyncWork(1,"222");
        pool.execute(asyncWork);
        Thread.sleep(3000);
        System.out.println("分配完成");
        asyncWork.setResult(1);
    }
}
