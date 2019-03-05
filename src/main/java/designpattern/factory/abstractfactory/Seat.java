package designpattern.factory.abstractfactory;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public interface Seat {
    void sofa();
}

class LuxurySeat implements Seat{

    @Override
    public void sofa() {
        System.out.println("好的沙发很软");
    }
}

class LowSeat implements Seat{

    @Override
    public void sofa() {
        System.out.println("垃圾的沙发很硬");
    }
}


