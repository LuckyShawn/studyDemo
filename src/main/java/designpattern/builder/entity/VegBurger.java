package designpattern.builder.entity;

import designpattern.builder.abs.Burger;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
