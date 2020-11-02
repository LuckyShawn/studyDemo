package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Type;

/**
 * @author Shawn
 * @title: SUV
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/29
 */
public class SUV implements Type {
    @Override
    public void isType() {
        System.out.println("SUV");
    }
}
