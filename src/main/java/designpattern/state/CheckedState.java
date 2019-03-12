package designpattern.state;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class CheckedState implements State {
    @Override
    public void handle() {
        System.out.println("入住状态");
    }
}
