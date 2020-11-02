package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Brand;

/**
 * @author Shawn
 * @title: Audi
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/29
 */
public class Audi implements Brand {
    @Override
    public void isBrand() {
        System.out.println("Audi");
    }
}
