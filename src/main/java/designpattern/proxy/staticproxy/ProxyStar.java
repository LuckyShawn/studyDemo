package designpattern.proxy.staticproxy;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/6 0006
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("confer() ");
    }

    @Override
    public void signContract() {
        System.out.println("signContract() ");
    }

    @Override
    public void bookTicket() {
        System.out.println("bookTicket() ");
    }

    /**
     * 代理真实明星安排唱歌
     */
    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("collectMoney() ");
    }
}
