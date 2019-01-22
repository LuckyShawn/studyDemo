package designpattern.observer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class OctalObserver extends Observer{
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
