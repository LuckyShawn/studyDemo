package designpattern.prototype.prototype;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Rectangle extends Shape {
    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
