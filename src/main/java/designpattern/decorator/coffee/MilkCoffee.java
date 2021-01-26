package designpattern.decorator.coffee;

/**
 * @author Shawn
 * @title: MilkCoffee
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/6
 */
public class MilkCoffee extends CoffeeDecorator {

    public MilkCoffee(Drink coffeeDecorator) {
        super(coffeeDecorator);
    }

    @Override
    public int cost() {
        return super.cost()+2;
    }

    @Override
    public String info() {
        return super.info()+"加牛奶";
    }
}
