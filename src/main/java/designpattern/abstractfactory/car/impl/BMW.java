package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Brand;

/**
 * @author Shawn
 * @title: BMW
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/29
 */
public class BMW implements Brand {
    @Override
    public void isBrand() {
        System.out.println("BMW");
    }
}
