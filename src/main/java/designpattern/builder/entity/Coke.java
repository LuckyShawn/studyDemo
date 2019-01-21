package designpattern.builder.entity;

import designpattern.builder.abs.ColdDrink;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
