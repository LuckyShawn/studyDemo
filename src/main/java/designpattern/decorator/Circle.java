package designpattern.decorator;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
