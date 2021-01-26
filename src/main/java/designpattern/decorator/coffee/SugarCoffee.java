package designpattern.decorator.coffee;

/**
 * @author Shawn
 * @title: SugarCoffee
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/6
 */
public class SugarCoffee extends CoffeeDecorator {
    public SugarCoffee(Drink coffeeDecorator) {
        super(coffeeDecorator);
    }

    @Override
    public int cost(){
        return super.cost()+1;
    }

    @Override
    public String info(){
        return super.info() + "加糖";
    }
}
