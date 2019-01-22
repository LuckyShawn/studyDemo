package designpattern.strategy;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class Multiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
