package designpattern.strategy.dianshangcelue;

import java.math.BigDecimal;

/**
 * @author Shawn
 * @title: FullReduction 满减
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/2
 */
public class FullReduction implements Strategy {

    @Override
    public BigDecimal selectDiscount(BigDecimal price) {
        System.out.println("满减");
        return price.subtract((price.divide(new BigDecimal(200))).multiply(new BigDecimal(40)));
    }
}
