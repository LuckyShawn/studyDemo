package designpattern.decorator.car;

/**
 * @Description 一辆车增加三种组合功能
 * @Author shawn
 * @create 2019/3/7 0007
 */
public class Client {
    public static void main(String[] args){
        ICar car = new SuperCarDecorator(new FlyCar(new AICar(new WaterCar(new Car()))));
        car.move();
    }
}
