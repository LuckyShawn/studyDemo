package designpattern.prototype.prototype;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Square extends Shape{
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
