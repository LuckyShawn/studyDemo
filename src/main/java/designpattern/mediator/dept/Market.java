package designpattern.mediator.dept;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Market implements Dept {

    Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("天天跑市场啊！接项目啊");
    }

    @Override
    public void outAction() {
        System.out.println("财务给点资金啊！");
        mediator.command("financial");
    }
}
