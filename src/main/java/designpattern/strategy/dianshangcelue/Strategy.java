package designpattern.strategy.dianshangcelue;

import java.math.BigDecimal;

/**
 * @author Shawn
 * @title: Strategy  电商满减，打折，
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/2
 */
public interface Strategy {
    BigDecimal selectDiscount(BigDecimal price);
}
