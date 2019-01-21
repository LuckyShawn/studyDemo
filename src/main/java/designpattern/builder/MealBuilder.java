package designpattern.builder;

import designpattern.builder.entity.ChickenBurger;
import designpattern.builder.entity.Coke;
import designpattern.builder.entity.Pepsi;
import designpattern.builder.entity.VegBurger;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class MealBuilder {
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
