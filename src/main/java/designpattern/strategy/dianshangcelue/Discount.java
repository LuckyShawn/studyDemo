package designpattern.strategy.dianshangcelue;

import java.math.BigDecimal;

/**
 * @author Shawn
 * @title: Discount 打折
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/2
 */
public class Discount implements Strategy {

    //八折
    public static final double DISCOUNT = 0.5;

    @Override
    public BigDecimal selectDiscount(BigDecimal price) {
        System.out.println("打折");
        return price.multiply(new BigDecimal(DISCOUNT));
    }
}
