package study.Exception;

/**
 * @author Shawn
 * @title: BankAccount
 * @projectName studyDemo
 * @description: 模拟银行账户，存取款
 * @date 2020/12/8
 */
public class BankAccount {
    //balance为余额，number为卡号
    private double balance;
    private int number;

    public BankAccount(int number)
    {
        this.number = number;
    }

    //存钱
    public void deposit(double amount) {
        balance += amount;
        System.out.println("存入："+ amount + "元");
    }

    //方法：取钱
    public void withdraw(double amount) throws CustomCheckedException {
        if(amount <= balance)
        {
            balance -= amount;
            System.out.println("取出："+ amount + "元");
        }
        else
        {
            double needs = amount - balance;
            throw new CustomCheckedException(needs,"余额不足");
        }
    }

    //方法：返回余额
    public double getBalance()
    {
        return balance;
    }
    //方法：返回卡号
    public int getNumber()
    {
        return number;
    }
}
