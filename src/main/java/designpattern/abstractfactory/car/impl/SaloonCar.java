package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Type;

/**
 * @author Shawn
 * @title: SaloonCar
 * @projectName studyDemo
 * @description: TODO 轿车
 * @date 2020/10/29
 */
public class SaloonCar implements Type {
    @Override
    public void isType() {
        System.out.println("轿车");
    }
}
