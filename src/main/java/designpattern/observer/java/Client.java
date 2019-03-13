package designpattern.observer.java;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/13 0013
 */
public class Client {
    public static void main(String[] args){
        ConcreteSubject subject = new ConcreteSubject();

        //创建观察者
        ObserverA observerA1 = new ObserverA();
        ObserverA observerA2 = new ObserverA();
        ObserverA observerA3 = new ObserverA();
        ObserverA observerA4 = new ObserverA();

        //将观察者注册进目标对象subject容器中
        subject.addObserver(observerA1);
        subject.addObserver(observerA2);
        subject.addObserver(observerA3);
        subject.addObserver(observerA4);

        //改变state值
        subject.setState(1000);
        System.out.println("===========");
        System.out.println(observerA1.getStateA());
        System.out.println(observerA2.getStateA());
        System.out.println(observerA3.getStateA());
        System.out.println(observerA4.getStateA());

        //改变state值
        subject.setState(50);
        System.out.println("===========");
        System.out.println(observerA1.getStateA());
        System.out.println(observerA2.getStateA());
        System.out.println(observerA3.getStateA());
        System.out.println(observerA4.getStateA());
    }
}
