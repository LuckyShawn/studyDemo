package thread;

/**
 * @author Shawn
 * @title: MyThread
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/11/29
 */
public class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"正在执行....");
        }

}
