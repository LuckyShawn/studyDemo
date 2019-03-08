package designpattern.Flyweight;

import java.util.HashMap;

/**
 * @Description 享元工厂类
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class ShapeFactory {
    private static final HashMap<String,Shape> circleMap = new HashMap<String,Shape>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
