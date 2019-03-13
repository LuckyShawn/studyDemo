package designpattern.observer.observer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/13 0013
 */
public class ObserverA extends Observer{

    private int stateA;  //stateA与目标对象的state值保持一致

    public ObserverA(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject) {
        stateA = ((ConcreteSubject)subject).getState();
    }

    public int getStateA() {
        return stateA;
    }

    public void setStateA(int stateA) {
        this.stateA = stateA;
    }
}
