package designpattern.observer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
