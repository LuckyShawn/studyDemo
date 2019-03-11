package designpattern.mediator.dept;

/**
 * @Description 部门抽象接口
 * @Author shawn
 * @create 2019/3/11 0011
 */
public interface Dept {
    void selfAction(); //做本部门的事情
    void outAction();  //向总经理发出申请
}
