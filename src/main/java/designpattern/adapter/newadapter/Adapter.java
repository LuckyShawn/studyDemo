package designpattern.adapter.newadapter;

/**
 * @Description 适配器类（相当于转接口（圆形接口与USB接口转接））
 * @Author shawn
 * @create 2019/3/6 0006
 */
public class Adapter implements Target{
    private Adaptee adaptee;

    @Override
    public void adapterHandle(){
        adaptee.out();
    }

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
