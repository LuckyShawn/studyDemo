package designpattern.observer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class ObserverTest {
    public static void main(String[] args){
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
