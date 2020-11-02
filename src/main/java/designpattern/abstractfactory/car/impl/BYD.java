package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Brand;

/**
 * @author Shawn
 * @title: BYD
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/29
 */
public class BYD implements Brand {
    @Override
    public void isBrand() {
        System.out.println("BYD");
    }
}
