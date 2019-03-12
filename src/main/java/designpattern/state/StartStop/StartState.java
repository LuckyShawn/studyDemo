package designpattern.state.StartStop;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("开始状态");
        context.setState(this);
    }

    public String toString(){
        return "Start state";
    }
}
