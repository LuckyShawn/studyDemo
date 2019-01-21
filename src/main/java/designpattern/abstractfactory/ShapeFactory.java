package designpattern.abstractfactory;

import designpattern.abstractfactory.impl.*;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class ShapeFactory extends AbstractFactory {

    //获取形状
    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    //获取颜色
    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
