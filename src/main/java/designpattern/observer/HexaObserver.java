package designpattern.observer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class HexaObserver extends Observer {
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
