package designpattern.strategy.dianshangcelue;

import java.math.BigDecimal;

/**
 * @author Shawn
 * @title: StrategyTest
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/2
 */
public class StrategyTest {
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext(new FullReduction());
        context.getPrice(new BigDecimal(50000));

        context = new StrategyContext(new Discount());
        context.getPrice(new BigDecimal(50000));

        context = new StrategyContext( new Coupon());
        context.getPrice(new BigDecimal(50000));

    }
}
