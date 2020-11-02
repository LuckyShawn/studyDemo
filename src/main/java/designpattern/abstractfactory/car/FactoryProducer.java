package designpattern.abstractfactory.car;

/**
 * @author Administrator
 * @title: FactoryProducer
 * @projectName studyDemo
 * @description: 抽象工厂生成类
 * @date 2020/10/27 20:42
 */
public class FactoryProducer {
    public static AbstractFactory getFactroty(String choice){
        switch (choice){
            case "BRAND":
                return new BrandFactory();
            case "TYPE":
                return new TypeFactory();
            case "COLOR":
                return new ColorFactory();
        }
        return null;
    }
}
