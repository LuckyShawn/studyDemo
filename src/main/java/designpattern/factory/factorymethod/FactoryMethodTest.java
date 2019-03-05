package designpattern.factory.factorymethod;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class FactoryMethodTest {
    public static void main(String[] args){
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BYDFactory().createCar();
        //新加一个工厂
        Car c3 = new BenzFactory().createCar();
        c1.run();
        c2.run();
        c3.run();
    }
}
