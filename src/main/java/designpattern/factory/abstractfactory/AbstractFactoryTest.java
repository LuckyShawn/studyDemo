package designpattern.factory.abstractfactory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class AbstractFactoryTest {
    public static void main(String[] args){
        CarFactory luxury = new LuxuryFactory();
        Engine engine = luxury.createEngine();
        Seat seat = luxury.createSeat();
        Tyre tyre = luxury.createTyre();
        engine.run();
        engine.start();
        seat.sofa();
        tyre.round();

        System.out.println("==================================");
        CarFactory low = new LowFactory();
        engine = low.createEngine();
        seat = low.createSeat();
        tyre = low.createTyre();
        engine.run();
        engine.start();
        seat.sofa();
        tyre.round();
    }
}
