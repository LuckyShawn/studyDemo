package designpattern.decorator.car;

/**
 * @Description 真实汽车类，具体构建的对象，被装饰类
 * @Author shawn
 * @create 2019/3/7 0007
 */
public class Car implements ICar {
    @Override
    public void move() {
        System.out.println("汽车在陆地上跑！");
    }
}
