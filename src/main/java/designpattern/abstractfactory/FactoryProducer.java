package designpattern.abstractfactory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if("SHAPE".equalsIgnoreCase(choice)){
            return new ShapeFactory();
        }else if("COLOR".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        return null;
    }
}
