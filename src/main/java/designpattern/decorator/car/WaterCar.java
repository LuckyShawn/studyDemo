package designpattern.decorator.car;

/**
 * @Description 新增飞天功能
 * @Author shawn
 * @create 2019/3/7 0007
 */
public class WaterCar extends SuperCarDecorator{

    public WaterCar(ICar car) {
        super(car);
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
    //新增功能
    private void swim() {
        System.out.println("车水中游！");
    }
}
