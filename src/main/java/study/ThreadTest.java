package study;

/**
 * @Description 多线程断点调试
 * @Author shawn
 * @create 2019/1/28 0028
 */
class ThreadNum implements Runnable {
    @Override
    public void run() {
        synchronized (this) {

            for (int i = 0; i < 100; i++) {

                System.out.println(Thread.currentThread().getName() + "数字：" + i);
                try {
                    notify();
                    Thread.sleep(100);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}

public class ThreadTest {
    public static void main(String[] args) {
        ThreadNum n = new ThreadNum();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
