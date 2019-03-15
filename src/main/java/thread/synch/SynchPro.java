package thread.synch;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/14 0014
 */
public class SynchPro {

    public synchronized void method1() {
        System.out.println("我是普通方法形式的对象锁");
    }

    public void method2() {
        synchronized (this) {
            System.out.println("我是代码块形式的对象锁");
        }
    }

    public static synchronized void method3() {
        System.out.println("我是静态方法形式的类锁");
    }

    public void method4() {
        synchronized(SynchPro.class) {
            System.out.println("我是代码块形式的类锁");
        }
    }
}
