package designpattern.command;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Client {
    public static void main(String[] args){
        Command command = new ConcreteCommand(new Receiver());
        Invoke invoke = new Invoke(command);
        invoke.call();
        //不使用设计模式
        new Receiver().action();
    }
}
