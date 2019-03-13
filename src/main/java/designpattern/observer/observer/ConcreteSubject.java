package designpattern.observer.observer;

/**
 * @Description 具体目标对象
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class ConcreteSubject extends Subject {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state){
        this.state = state;
        //主体对象（目标对象）值发生变化，通知所有观察者
        this.notifyAllAbserver();
    }

}
