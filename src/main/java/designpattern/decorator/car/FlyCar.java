package designpattern.decorator.car;

/**
 * @Description 新增飞天功能
 * @Author shawn
 * @create 2019/3/7 0007
 */
public class FlyCar extends SuperCarDecorator{

    public FlyCar(ICar car) {
        super(car);
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
    //新增功能
    private void fly() {
        System.out.println("车天上飞！");
    }
}
