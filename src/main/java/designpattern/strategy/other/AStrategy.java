package designpattern.strategy.other;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class AStrategy implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("A客户9折");
        return price*0.9;
    }
}
