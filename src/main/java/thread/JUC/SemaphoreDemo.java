package thread.JUC;

import java.util.concurrent.Semaphore;

/**
 * @author Shawn
 * @title: SemaphoreDemo 信号量
 * @projectName studyDemo
 * @description: 类似于锁：控制对某组资源的访问权限
 * @date 2022/2/17
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        int N = 8;//工人数
        Semaphore sp = new Semaphore(5);
        for (int i = 0; i < N; i++) {
            new SemaphoreThread(i,sp).start();
        }
    }

    public static class SemaphoreThread extends Thread{
        private Semaphore sp;
        private int num;//几号工人
        public SemaphoreThread(int num,Semaphore sp){
            this.num = num;
            this.sp = sp;
        }
        @Override
        public void run() {
            try {
                sp.acquire(2);
                System.out.println("工人"+this.num +"占用："+Thread.currentThread());
                Thread.sleep(2000);
                sp.release(2);
                System.out.println("工人"+this.num +"释放："+Thread.currentThread());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
