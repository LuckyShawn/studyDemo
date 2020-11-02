package designpattern.abstractfactory.car.impl;

import designpattern.abstractfactory.car.Type;

/**
 * @author Shawn
 * @title: MPV
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/10/29
 */
public class MPV implements Type {
    @Override
    public void isType() {
        System.out.println("SUV");
    }
}
