package designpattern.Flyweight;

/**
 * @Description 创建了20个不同效果的圆，但相同颜色的圆只需要创建一次便可
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class FlyweightPatternDemo {

    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args){
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor(){
        return colors[(int)(Math.random()*colors.length)];
    }

    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}
