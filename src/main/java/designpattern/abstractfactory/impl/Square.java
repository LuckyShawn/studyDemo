package designpattern.abstractfactory.impl;

import designpattern.abstractfactory.Shape;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Square implements Shape {
    @Override
    public void draw() {
        for (int i = 0; i < 5; i++) {//行数
            for (int j = 0; j < 9; j++) {//*号个数
                System.out.print("*");
            }
            System.out.println();//换行
        }
    }
}

