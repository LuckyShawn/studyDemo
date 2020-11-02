package designpattern.abstractfactory.car;

/**
 * @author Shawn
 * @title: AbstractFactoryTest01
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/29
 */
public class AbstractFactoryTest01 {
    public static void main(String[] args) {
        AbstractFactory brandFactory = FactoryProducer.getFactroty("BRAND");
        Brand brand = brandFactory.getBrand("AUDI");
        brand.isBrand();

        AbstractFactory typeFactory = FactoryProducer.getFactroty("TYPE");
        Type type = typeFactory.getType("SUV");
        type.isType();

        AbstractFactory colorFactory = FactoryProducer.getFactroty("COLOR");
        Color gray = colorFactory.getColor("GRAY");
        gray.fill();

    }
}
