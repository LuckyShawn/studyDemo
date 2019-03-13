package designpattern.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 负责人类
 * @Author shawn
 * @create 2019/3/13 0013
 */
public class CareTaker {
    private EmpMemento empMemento;

    //可以备忘多次
    //private List<EmpMemento> list = new ArrayList<>();
    private Stack<EmpMemento> stack = new Stack<>();

    public EmpMemento getEmpMemento() {
        return empMemento;
    }

    public void setEmpMemento(EmpMemento empMemento) {
        this.empMemento = empMemento;
    }

    public EmpMemento getStack() {
        return stack.pop();
    }

    public void setStack(EmpMemento empMemento) {
        this.stack.push(empMemento);
    }
}
