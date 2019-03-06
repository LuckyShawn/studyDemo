package designpattern.adapter.newadapter;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/6 0006
 */
public class Client {
    public static void main(String[] args){
        //用户只需要将键盘插入转接器（adapter）就可以使用键盘操作电脑了
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.adapterHandle();
    }
}
