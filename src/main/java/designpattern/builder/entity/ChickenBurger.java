package designpattern.builder.entity;

import designpattern.builder.abs.Burger;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
