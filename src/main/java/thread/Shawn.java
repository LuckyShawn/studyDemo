package thread;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/28 0028
 */
public class Shawn implements Runnable {
     Bank bank;
     String mode;

    public Shawn(Bank bank, String mode) {
        this.bank = bank;
        this.mode = mode;
    }

    @Override
    public void run() {
        while(Bank.money >= 200){
            try {
                bank.outMoney(200,mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
