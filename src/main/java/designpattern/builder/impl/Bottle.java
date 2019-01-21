package designpattern.builder.impl;

import designpattern.builder.Packing;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "瓶装";
    }

}
