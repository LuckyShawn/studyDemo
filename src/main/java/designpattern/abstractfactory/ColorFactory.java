package designpattern.abstractfactory;

import designpattern.abstractfactory.impl.Blue;
import designpattern.abstractfactory.impl.Red;
import designpattern.abstractfactory.impl.Yellow;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class ColorFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        if(colorType == null){
            return null;
        }
        if(colorType.equalsIgnoreCase("RED")){
            return new Red();
        } else if(colorType.equalsIgnoreCase("YELLOW")){
            return new Yellow();
        } else if(colorType.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
