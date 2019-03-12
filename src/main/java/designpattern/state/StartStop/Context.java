package designpattern.state.StartStop;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class Context  {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
