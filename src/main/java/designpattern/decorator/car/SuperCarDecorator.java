package designpattern.decorator.car;

/**
 * @Description 装饰器类，也叫包装类（Wrapper）
 * @Author shawn
 * @create 2019/3/7 0007
 */
public class SuperCarDecorator implements ICar{
    protected ICar car;

    public SuperCarDecorator(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
