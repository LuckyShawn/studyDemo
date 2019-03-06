package designpattern.proxy.staticproxy;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/6 0006
 */
public class Client {
    public static void main(String[] args){
        Star star = new RealStar();
        ProxyStar proxyStar = new ProxyStar(star);
        proxyStar.bookTicket();
        proxyStar.collectMoney();
        proxyStar.confer();
        proxyStar.sing();
        proxyStar.signContract();
    }
}
