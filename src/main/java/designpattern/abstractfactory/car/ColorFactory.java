package designpattern.abstractfactory.car;

import designpattern.abstractfactory.car.impl.Black;
import designpattern.abstractfactory.car.impl.Gray;
import designpattern.abstractfactory.car.impl.Red;

public class ColorFactory extends AbstractFactory{
    @Override
    public Brand getBrand(String brand) {
        return null;
    }

    @Override
    public Type getType(String type) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("BLACK")){
            return new Black();
        } else if(color.equalsIgnoreCase("GRAY")){
            return new Gray();
        }
        return null;
    }
}
