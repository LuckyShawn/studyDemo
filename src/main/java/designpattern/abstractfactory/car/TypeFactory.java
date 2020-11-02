package designpattern.abstractfactory.car;

import designpattern.abstractfactory.car.impl.*;

public class TypeFactory extends AbstractFactory{

    @Override
    public Brand getBrand(String brand) {
        return null;
    }

    @Override
    public Type getType(String type) {
        if(type == null) {
            return null;
        }
        switch (type){
            case "SUV":
                return new SUV();
            case "BYD":
                return new MPV();
            case "BMW":
                return new SaloonCar();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
