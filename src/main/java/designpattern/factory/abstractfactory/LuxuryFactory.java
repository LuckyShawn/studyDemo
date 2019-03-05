package designpattern.factory.abstractfactory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class LuxuryFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}
