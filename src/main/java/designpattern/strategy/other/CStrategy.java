package designpattern.strategy.other;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class CStrategy implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("B客户7折");
        return price*0.7;
    }
}
