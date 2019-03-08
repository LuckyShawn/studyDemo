package designpattern.facade;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class C implements ABCI{
    public void close(){
        System.out.println("关闭冰箱！");
    }

    @Override
    public void handler() {
        System.out.println("关闭冰箱！");
    }
}
