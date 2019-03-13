package designpattern.strategy.other;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class BStrategy implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("B客户8折");
        return price*0.8;
    }
}
