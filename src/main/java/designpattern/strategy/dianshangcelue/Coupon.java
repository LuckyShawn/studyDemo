package designpattern.strategy.dianshangcelue;

import java.math.BigDecimal;

/**
 * @author Shawn
 * @title: Coupon 优惠券
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/2
 */
public class Coupon implements Strategy{

    //五元优惠券
    public static final double WU_YUAN = 5;

    @Override
    public BigDecimal selectDiscount(BigDecimal price) {
        System.out.println("优惠券");
        return price.subtract(new BigDecimal(WU_YUAN)) ;
    }
}
