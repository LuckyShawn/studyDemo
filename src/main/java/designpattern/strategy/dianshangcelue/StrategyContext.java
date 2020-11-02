package designpattern.strategy.dianshangcelue;

import java.math.BigDecimal;

/**
 * @author Shawn
 * @title: StrategyContext
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/2
 */
public class StrategyContext {
    Strategy strategy;

    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }

    //通过set方法注入
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void getPrice(BigDecimal s){
        System.out.println("您的报价是："+strategy.selectDiscount(s));
    }
}
