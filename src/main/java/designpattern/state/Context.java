package designpattern.state;

/**
 * @Description 上下文，切换状态
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class Context {

    private State state;

    public void setState(State s){
        System.out.println("修改状态！");
        state = s;
        state.handle();
    }
}
