package designpattern.builder;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
