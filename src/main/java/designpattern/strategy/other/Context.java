package designpattern.strategy.other;

/**
 * @Description 负责和具体的策略类交互
 * 具体的算法和直接的客户端调用分离，使算法可以独立于客户端独立变化
 * 可以通过Spring的依赖注入，配置文件注入
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Context {
    private Strategy strategy;  //当前采用的算法对象

    //通过构造器注入
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    //通过set方法注入
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void getPrice(double s){
        System.out.println("您的报价是："+strategy.getPrice(s));
    }
}
