package designpattern.Flyweight.chess;

/**
 * @Description 享元类：提供内部状态，设置外部状态
 * @Author shawn
 * @create 2019/3/8 0008
 */
public interface ChessFlyWeight {
    void setColor(String c);

    String getColor();

    String getShape();

    void setShape(String shape);

    void display(Coordinate c);
}

/**
 * 具体享元类：为内部状态提供成员变量进行储存
 */
class ConcreteChess implements ChessFlyWeight {

    private String color;
    private String shape;


    public ConcreteChess(String color, String shape) {
        super();
        this.color = color;
        this.shape = shape;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子颜色：" + color);
        System.out.println("棋子形状：" + shape);
        System.out.println("棋子位置：" + c.getX() + "----" + c.getY());
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String c) {
        this.color = c;
    }

    @Override
    public String getShape() {
        return shape;
    }

    @Override
    public void setShape(String shape) {
        this.shape = shape;
    }

}
