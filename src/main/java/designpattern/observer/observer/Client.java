package designpattern.observer.observer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/13 0013
 */
public class Client {
    public static void main(String[] args){
        //目标对象
        ConcreteSubject subject = new ConcreteSubject();

        //创建多个观察者 并将观察者注册到列表
        ObserverA observerA1 = new ObserverA(subject);
        ObserverA observerA2 = new ObserverA(subject);
        ObserverA observerA3 = new ObserverA(subject);

        System.out.println(observerA1.getStateA());
        System.out.println(observerA2.getStateA());
        System.out.println(observerA3.getStateA());
        System.out.println("====================");

        subject.setState(1000);

        System.out.println(observerA1.getStateA());
        System.out.println(observerA2.getStateA());
        System.out.println(observerA3.getStateA());
        System.out.println("====================");
        subject.setState(500);

        System.out.println(observerA1.getStateA());
        System.out.println(observerA2.getStateA());
        System.out.println(observerA3.getStateA());

    }
}
