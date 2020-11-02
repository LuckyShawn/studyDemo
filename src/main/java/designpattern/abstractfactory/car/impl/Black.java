package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Color;

/**
 * @author Shawn
 * @title: Black
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/29
 */
public class Black implements Color {
    @Override
    public void fill() {
        System.out.println("神秘黑");
    }
}
