package designpattern.mediator.dept;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Financial implements Dept {

    Mediator mediator;

    public Financial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("financial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("天天数钱，好累");
    }

    @Override
    public void outAction() {
        System.out.println("这些钱都给你们吧");
    }
}
