package designpattern.builder.abs;

import designpattern.builder.Item;
import designpattern.builder.Packing;
import designpattern.builder.impl.Bottle;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
