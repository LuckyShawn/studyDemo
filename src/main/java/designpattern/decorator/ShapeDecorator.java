package designpattern.decorator;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }

}
