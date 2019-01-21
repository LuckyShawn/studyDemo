package designpattern.factory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class FactoryTest {
    public static void main(String[] args){
        ShapeFactory factory = new ShapeFactory();

        Shape shape = factory.getShape("CIRCLE");
        shape.draw();
        System.out.println("------------------------");
        shape = factory.getShape("RECTANGLE");
        shape.draw();
        System.out.println("------------------------");
        shape = factory.getShape("SQUARE");
        shape.draw();
    }
}
