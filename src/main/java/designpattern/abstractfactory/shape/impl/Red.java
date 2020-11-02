package designpattern.abstractfactory.shape.impl;

import designpattern.abstractfactory.shape.Color;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("填充红色");
    }
}
