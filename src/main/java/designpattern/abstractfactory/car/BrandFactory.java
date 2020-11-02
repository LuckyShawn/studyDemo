package designpattern.abstractfactory.car;


import designpattern.abstractfactory.car.impl.*;

public class BrandFactory extends AbstractFactory{
    @Override
    public Brand getBrand(String brand) {
        if(brand == null) {
            return null;
        }
        switch (brand){
            case "AUDI":
                return new Audi();
            case "BYD":
                return new BYD();
            case "BMW":
                return new BMW();
        }
        return null;
    }

    @Override
    public Type getType(String type) { return null; }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
