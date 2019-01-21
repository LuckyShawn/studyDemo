package designpattern.abstractfactory;

/**
 * @Description 抽象工厂
 * @Author shawn
 * @create 2019/1/21 0021
 */
public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
    public abstract Color getColor(String colorType);
}
