package designpattern.decorator.coffee;

/**
 * @author Shawn
 * @title: CoffeeDecorator
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/6
 */
public abstract class CoffeeDecorator implements Drink {

    protected Drink coffeeDecorator;

    public CoffeeDecorator(Drink coffeeDecorator){
        this.coffeeDecorator = coffeeDecorator;
    }

    @Override
    public int cost() {
        return coffeeDecorator.cost();
    }

    @Override
    public String info() {
        return coffeeDecorator.info();
    }
}
