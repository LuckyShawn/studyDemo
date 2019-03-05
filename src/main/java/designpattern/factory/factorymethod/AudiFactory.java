package designpattern.factory.factorymethod;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class AudiFactory implements CarFactory{

    @Override
    public Car createCar() {
        return new Audi();
    }
}
