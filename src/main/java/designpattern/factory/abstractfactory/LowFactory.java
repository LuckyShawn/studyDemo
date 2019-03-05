package designpattern.factory.abstractfactory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class LowFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}
