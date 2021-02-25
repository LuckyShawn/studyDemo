package annotation.Demo;

/**
 * @author Shawn
 * @title: TestLock
 * @projectName 使用jstack pid 查看死锁的例子
 * @description: TODO
 * @date 2021/1/29
 */
public class TestLock {
    public static void main(String[] args) {
        Person person01 = new Person();
        Person person02 = new Person();
        Person person03 = new Person();
        Person person04 = new Person();
        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (person01){
                        Thread.sleep(2000);
                        System.out.println("person01");
                        synchronized (person02){
                            Thread.sleep(2000);
                            System.out.println("person02");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (person02){
                        Thread.sleep(2000);
                        System.out.println("person02");
                        synchronized (person01){
                            Thread.sleep(2000);
                            System.out.println("person01");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread03 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (person04){
                        Thread.sleep(2000);
                        System.out.println("person04");
                        synchronized (person03){
                            Thread.sleep(2000);
                            System.out.println("person03");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread04 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (person03){
                        Thread.sleep(2000);
                        System.out.println("person03");
                        synchronized (person04){
                            Thread.sleep(2000);
                            System.out.println("person04");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread02.start();
        thread01.start();
        thread03.start();
        thread04.start();
    }


}

class Person{
    String name = "";
    int age = 0;
}
