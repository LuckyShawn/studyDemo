package designpattern.bridge;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/7 0007
 */
public class Client {
    public static void main(String[] args){
        Computer c = new Desktop(new Lenovo());
        c.sale();
        Computer c1 = new Laptop(new Shenzhou());
        c1.sale();
        Computer c2 = new BlueTeeth(new Lenovo());
        c2.sale();
        Computer c3 = new BlueTeeth(new Dell());
        c3.sale();
    }
}
