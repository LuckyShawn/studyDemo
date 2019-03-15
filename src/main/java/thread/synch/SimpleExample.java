package thread.synch;

/**
 * @Description 多个实例，对当前实例加锁，同步执行，对当前类Class对象加锁，异步执行。
 * @Author shawn
 * @create 2019/3/14 0014
 */
public class SimpleExample implements Runnable{

    @Override
    public void run() {
        //method1();    //普通方法形式的对象锁   同一个对象同步执行，不同对象异步执行
        //method2();    //静态方法形式的类锁     不管是同一个对象还是多个对象，都是同步执行
        //method3();    //代码块形式的对象锁     同一个对象同步执行，不同对象异步执行
        method4();    //代码块形式的类锁       不管是同一个对象还是多个对象，都是同步执行
       // method5();    //普通方法
        //method6();    //静态方法
    }
    public synchronized void method1() {
        common();
    }

    public static synchronized void method2() {
        commonStatic();
    }

    public void method3() {
        synchronized(this) {
            common();
        }
    }

    public void method4() {
        synchronized(SimpleExample.class) {
            common();
        }
    }

    public void method5() {
        common();
    }

    public void method6() {
        commonStatic();
    }

    public void common() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕");
    }

    public static void commonStatic() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleExample instance1 = new SimpleExample();
        SimpleExample instance2 = new SimpleExample();
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("finished");
    }
}

