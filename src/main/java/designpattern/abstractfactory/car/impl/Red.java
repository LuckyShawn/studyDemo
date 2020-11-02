package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Color;

/**
 * @author Shawn
 * @title: Red
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/28
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("朱雀红");
    }
}
