package designpattern.abstractfactory.car;

/**
 * @author Shawn
 * @title: AbstractFactory
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/27
 */
public abstract class AbstractFactory {
    public abstract Brand getBrand(String brand);
    public abstract Type getType(String type);
    public abstract Color getColor(String color);
}
