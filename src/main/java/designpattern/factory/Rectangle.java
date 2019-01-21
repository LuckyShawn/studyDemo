package designpattern.factory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        for (int x=0; x<3; x++) {
            for (int y=0; y<4; y++) {
                System.out.print("*");//这里用print是打印长方形.如果用println则是竖着排列的*
            }
            System.out.println();//只有一个功能就是换行.
        }
    }
}
