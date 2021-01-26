package study.Exception;

/**
 * @author Shawn
 * @title: BankAccountTest
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/12/8
 */
public class BankAccountTest {

    public static void main(String[] args) {
        try {
            BankAccount bank = new BankAccount(111);
            bank.deposit(500);
            System.out.println(bank.getBalance());
            bank.withdraw(100);
            System.out.println(bank.getBalance());
            bank.withdraw(500);
        } catch (CustomCheckedException e) {
            e.printStackTrace();
            System.out.println(e.getMsg());
        }

    }
}
