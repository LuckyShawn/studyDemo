package designpattern.factory.abstractfactory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public interface Engine {
    void start();
    void run();
}

class LuxuryEngine implements Engine{

    @Override
    public void start() {
        System.out.println("高级发动机转的快");
    }

    @Override
    public void run() {
        System.out.println("高级的车有自动启停");
    }
}

class LowEngine implements Engine{

    @Override
    public void start() {
        System.out.println("垃圾发动机转的慢");
    }

    @Override
    public void run() {
        System.out.println("垃圾的车啥功能没有");
    }
}
