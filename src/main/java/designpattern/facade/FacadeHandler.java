package designpattern.facade;

/**
 * @Description 门面
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class FacadeHandler {

    private ABCI a;
    private ABCI b;
    private ABCI c;

    public FacadeHandler() {
        a = new A();
        b = new B();
        c = new C();
    }

    public void openPushClose(){
        a.handler();
        b.handler();
        c.handler();
    }

}
