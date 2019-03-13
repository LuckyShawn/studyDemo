package designpattern.observer.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 目标对象
 * @Author shawn
 * @create 2019/3/12 0012
 */
public class Subject {
    protected List<Observer> list = new ArrayList<>();

    public void registerObserver(Observer observer){
        list.add(observer);
    }

    public void removeObserver(Observer observer){
        list.remove(observer);
    }

    //通知所有的观察者更新
    public void notifyAllAbserver(){
        for(Observer observer : list){
            observer.update(this);
        }
    }
}
