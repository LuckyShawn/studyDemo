package designpattern.observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/13 0013
 */
public class ObserverA implements Observer {

    private int stateA;

    @Override
    public void update(Observable o, Object arg) {
        stateA = ((ConcreteSubject)o).getState();
    }

    public int getStateA() {
        return stateA;
    }

    public void setStateA(int stateA) {
        this.stateA = stateA;
    }
}
