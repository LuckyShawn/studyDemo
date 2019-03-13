package designpattern.strategy.other;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Client {
    public static void main(String[] args){
        Strategy aStrategy = new AStrategy();
        Strategy bStrategy = new BStrategy();
        Context context = new Context(aStrategy);
        context.getPrice(100);
        context = new Context(bStrategy);
        context.getPrice(100);
    }
}
