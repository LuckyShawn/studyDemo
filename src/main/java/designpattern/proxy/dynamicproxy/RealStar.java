package designpattern.proxy.dynamicproxy;

/**
 * @Description 真实明星
 * @Author shawn
 * @create 2019/3/6 0006
 */
public class RealStar implements Star {
    @Override
    public void confer() {

    }

    @Override
    public void signContract() {

    }

    @Override
    public void bookTicket() {

    }

    /**
     * 核心功能
     */
    @Override
    public void sing() {
        System.out.println("真实明星唱歌！");
    }

    @Override
    public void collectMoney() {

    }
}
