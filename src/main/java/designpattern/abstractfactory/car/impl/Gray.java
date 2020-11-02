package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Color;

/**
 * @author Shawn
 * @title: Gray
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/29
 */
public class Gray implements Color {
    @Override
    public void fill() {
        System.out.println("战斗灰");
    }
}
