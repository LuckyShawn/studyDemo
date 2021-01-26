package designpattern.decorator.coffee;

/**
 * @author Shawn
 * @title: Coffee
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/6
 */
public class Coffee implements Drink {
    private int price  = 5;

    private String name = "咖啡";

    @Override
    public int cost() {
        return price;
    }

    @Override
    public String info() {
        return name;
    }
}
