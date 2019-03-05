package designpattern.factory.abstractfactory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public interface Tyre {
    void round();
}

class LuxuryTyre implements Tyre{

    @Override
    public void round() {
        System.out.println("好的轮胎磨损比较小");
    }
}

class LowTyre implements Tyre{

    @Override
    public void round() {
        System.out.println("不好的轮胎磨损很快");
    }
}
