package designpattern.facade;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class A implements ABCI{
    public void open(){
        System.out.println("打开冰箱！");
    }

    @Override
    public void handler() {
        System.out.println("打开冰箱！");
    }
}
