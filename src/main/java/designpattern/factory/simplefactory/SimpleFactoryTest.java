package designpattern.factory.simplefactory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class SimpleFactoryTest {
    public static void main(String[] args){
        Car c1 = CarFactory.createCar("Audi");
        Car c2 = CarFactory.createCar("Byd");

        c1.run();
        c2.run();
    }
}
