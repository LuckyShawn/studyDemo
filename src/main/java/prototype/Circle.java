package prototype;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Circle extends Shape {
    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
