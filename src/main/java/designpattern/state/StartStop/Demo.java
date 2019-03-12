package designpattern.state.StartStop;

import designpattern.proxy.dynamicproxy.Star;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class Demo {
    public static void main(String[] args){
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
