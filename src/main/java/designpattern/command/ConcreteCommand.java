package designpattern.command;

/**
 * @Description 命令接口实现类
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //命令真正执行
        receiver.action();
    }
}
