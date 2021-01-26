package designpattern.decorator.coffee;

/**
 * @author Shawn
 * @title: Drink  饮品
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/6
 */
public interface Drink {
    /**
     * 花费
     */
    int cost();

    /**
     * 信息（是否加糖，是否加牛奶）
     */
    String info();
}
