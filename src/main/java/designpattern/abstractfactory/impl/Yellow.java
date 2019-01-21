package designpattern.abstractfactory.impl;

import designpattern.abstractfactory.Color;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Yellow implements Color {
    @Override
    public void fill() {
        System.out.println("填充黄色");
    }
}
