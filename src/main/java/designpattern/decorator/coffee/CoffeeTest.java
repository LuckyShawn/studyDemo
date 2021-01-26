package designpattern.decorator.coffee;

/**
 * @author Shawn
 * @title: CoffeeTest
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/6
 */
public class CoffeeTest {
    public static void main(String[] args) {
        Drink drink = new Coffee();
        System.out.println("饮品类型："+ drink.info()  +" | 花费："+ drink.cost() + "元");
        MilkCoffee milkCoffee = new MilkCoffee(drink);
        System.out.println("饮品类型："+ milkCoffee.info()  +" | 花费："+ milkCoffee.cost() + "元");
        SugarCoffee sugarCoffee = new SugarCoffee(milkCoffee);
        System.out.println("饮品类型："+ sugarCoffee.info()  +" | 花费："+ sugarCoffee.cost() + "元");

        SugarCoffee sugarCoffee1 =  new SugarCoffee(new Coffee());
        System.out.println("饮品类型："+ sugarCoffee1.info()  +" | 花费："+ sugarCoffee1.cost() + "元");

        SugarCoffee sugarCoffee2 =  new SugarCoffee(new MilkCoffee(new Coffee()));
        System.out.println("饮品类型："+ sugarCoffee2.info()  +" | 花费："+ sugarCoffee2.cost() + "元");
    }
}
