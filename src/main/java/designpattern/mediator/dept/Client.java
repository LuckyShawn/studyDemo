package designpattern.mediator.dept;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Client {
    public static void main(String[] args){
        Mediator mediator = new President();
        Dept finacial = new Financial(mediator);
        Dept market = new Market(mediator);
        Dept development = new Development(mediator);

        development.outAction();
        development.selfAction();

        market.selfAction();
        market.outAction();
    }
}
