package designpattern.facade;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class B implements ABCI{
    public void push(){
        System.out.println("将大象装进冰箱！");
    }

    @Override
    public void handler() {
        System.out.println("将大象装进冰箱！");
    }
}
