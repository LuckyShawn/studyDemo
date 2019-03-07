package designpattern.decorator.car;

/**
 * @Description 新增飞天功能
 * @Author shawn
 * @create 2019/3/7 0007
 */
public class AICar extends SuperCarDecorator{

    public AICar(ICar car) {
        super(car);
    }

    @Override
    public void move() {
        super.move();
        AI();
    }
    //新增功能
    private void AI() {
        System.out.println("智能驾驶！");
    }
}
