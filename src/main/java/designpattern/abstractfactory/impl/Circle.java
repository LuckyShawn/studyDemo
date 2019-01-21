package designpattern.abstractfactory.impl;

import designpattern.abstractfactory.Shape;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        int r = 5;
        for (int y = 0; y <= 2 * r; y += 2) {//y的步长为2,改变y的步长可以将圆形变成椭圆
            int x = (int)Math.round(r - Math.sqrt(2 * r * y - y * y));
            int len = 2 * (r - x);

            for (int i = 0; i <= x; i++) {
                System.out.print(' ');
            }
            System.out.print('*');

            for (int j = 0; j <= len; j++) {
                System.out.print(' ');
            }

            System.out.println('*');

        }
    }
}
