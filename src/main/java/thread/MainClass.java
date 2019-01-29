package thread;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/28 0028
 */
public class MainClass {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Jack jack = new Jack(bank, "ATM");
        Shawn shawn = new Shawn(bank, "柜台");
        Thread t1 = new Thread(jack);
        Thread t2 = new Thread(shawn);
        t1.start();
        t2.start();
    }
}
