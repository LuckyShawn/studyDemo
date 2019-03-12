package designpattern.state;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("空闲状态");
    }
}
