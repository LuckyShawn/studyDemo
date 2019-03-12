package designpattern.state.StartStop;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("停止状态");
        context.setState(this);
    }

    public String toString(){
        return "Stop state";
    }
}
