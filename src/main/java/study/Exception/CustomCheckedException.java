package study.Exception;

/**
 * @author Shawn
 * @title: 自定义异常demo  CustomException
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/12/8
 */
public class CustomCheckedException extends Exception{

    //此处的amount用来储存当出现异常（取出钱多于余额时）所缺乏的钱
    private double amount;

    private String msg;

    public CustomCheckedException(double amount,String msg){
        this.amount = amount;
        this.msg = msg;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
