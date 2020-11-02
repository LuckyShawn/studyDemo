package designpattern.abstractfactory.shape;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class AbstractFactoryTest {
    public static void main(String[] args){
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取形状为 Circle 的对象
        Shape shape = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape.draw();

        //获取形状为 Rectangle 的对象
        shape = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape.draw();

        //获取形状为 Square 的对象
        shape = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //获取颜色为 Red 的对象
        Color color = colorFactory.getColor("RED");

        //调用 Red 的 fill 方法
        color.fill();

        //获取颜色为 黄色 的对象
        color = colorFactory.getColor("Yellow");

        //调用 Green 的 fill 方法
        color.fill();

        //获取颜色为 Blue 的对象
        color = colorFactory.getColor("BLUE");

        //调用 Blue 的 fill 方法
        color.fill();
    }
}
