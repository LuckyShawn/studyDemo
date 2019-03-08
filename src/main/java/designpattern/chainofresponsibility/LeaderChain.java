package designpattern.chainofresponsibility;

/**
 * @Description 组织领导链
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class LeaderChain {
    Leader a;
    Leader d;
    Leader e;

    public LeaderChain() {
         a = new ALevel("张三");
         d = new DLevel("李四");
         e = new ELevel("王五");
        e.nextLeader = d;
        e.nextLeader = a;

    }

    public Leader getA() {
        return a;
    }

    public void setA(Leader a) {
        this.a = a;
    }

    public Leader getD() {
        return d;
    }

    public void setD(Leader d) {
        this.d = d;
    }

    public Leader getE() {
        return e;
    }

    public void setE(Leader e) {
        this.e = e;
    }
}
