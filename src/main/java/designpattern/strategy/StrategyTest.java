package designpattern.strategy;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class StrategyTest {
    public static void main(String[] args){
      Context context = new Context(new Add());

      System.out.println("1 + 2 = "+context.execute(1,2));

      context = new Context(new Substract());
      context.execute(2,1);
        System.out.println("2 - 1 = "+context.execute(2,1));

      context = new Context(new Multiply());
      context.execute(2,2);
        System.out.println("2 * 2 = "+context.execute(2,2));

    }
}
