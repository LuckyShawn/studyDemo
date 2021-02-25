package annotation.Demo;

import java.util.Vector;

/**
 * @author Shawn
 * @title: Test
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/1/26
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(002);//2
        System.out.println(0b11);//3  2进制
        System.out.println(011);//9   8进制
        System.out.println(0x11);//17  16进制
        Vector v=new Vector(10);
        for (int i=1;i<99999999; i++){
            Object o=new Object();
            v.add(o);
            //o=null;
            System.out.println(1111111);
            Object o1=new Object();
            v.add(o1);
            //o=null;
            System.out.println(2222222);
            Object o2=new Object();
            v.add(o2);
            //o=null;
            System.out.println(333333);
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getMe();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                getMe();
            }
        });
        thread1.start();
        thread.start();
    }

    public static void getMe(){
        int i = 1;
        while(i>0){
            String str = new String("AA:"+i++);
            System.out.println(str);
            System.out.println(Thread.currentThread());
        }
    }


}
