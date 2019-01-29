package thread;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/28 0028
 */
public class Jack implements Runnable {
     Bank bank;
     String mode;

    public Jack(Bank bank, String mode) {
        this.bank = bank;
        this.mode = mode;
    }

    @Override
    public void run() {
        while (Bank.money >= 100){
            try {
                bank.outMoney(100, mode);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
