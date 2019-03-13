package designpattern.observer.observer;

/**
 * @Description 观察者抽象接口  持有更新方法
 * @Author shawn
 * @create 2019/3/12 0012
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update(Subject subject);
}
