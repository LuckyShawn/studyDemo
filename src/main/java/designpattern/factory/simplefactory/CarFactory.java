package designpattern.factory.simplefactory;

/**
 * @Description 汽车工厂类，若要增加新的汽车，需要修改代码，违反开闭原则
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class CarFactory {
    //对比产出
    public static Car createCar(String type){
        if (type.equalsIgnoreCase("Audi")) {
            return new Audi();
        }else if(type.equalsIgnoreCase("BYD")){
            return new BYD();
        }else {
            return null;
        }
    }

    //直接调用产出
    public static Car createAudi(){
        return new Audi();
    }
    public static Car createBYD(){
        return new BYD();
    }
}
