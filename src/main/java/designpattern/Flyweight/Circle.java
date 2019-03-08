package designpattern.Flyweight;

/**
 * @Description 具体享元类对象
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class Circle implements Shape {

    private String color;   //颜色
    private int x;  //横坐标
    private int y;  //竖坐标
    private int radius; //半径

    public Circle(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }

}
