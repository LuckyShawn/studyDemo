package designpattern.observer.java;

import java.util.Observable;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/13 0013
 */
public class ConcreteSubject extends Observable {
    private int state;

    public void setState(int state){
        this.state = state; //目标对象的状态发生改变
        setChanged();   //表示目标对象发生改变
        notifyObservers(state); //通知所有的观察者
    }

    public int getState() {
        return state;
    }
}
