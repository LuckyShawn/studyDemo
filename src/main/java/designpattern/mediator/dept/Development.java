package designpattern.mediator.dept;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Development implements Dept {

    Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("专业开发！");
    }

    @Override
    public void outAction() {

        System.out.println("我需要开发资金！！");
        mediator.command("financial");
    }
}
