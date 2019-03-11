package designpattern.mediator.dept;

/**
 * @Description 中介者抽象接口
 * @Author shawn
 * @create 2019/3/11 0011
 */
public interface Mediator {
    //其他部门注册进来
    void register(String dname,Dept d);

    //命令其他部门
    void command(String dname);

}
