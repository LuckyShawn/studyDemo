package designpattern.chainofresponsibility;

/**
 * @Description 领导接口类
 * @Author shawn
 * @create 2019/3/8 0008
 */
public abstract class Leader {
    String name;
    Leader nextLeader;
    public abstract void handleRequest(LeaveRequest request);

    public Leader(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getNextLeader() {
        return nextLeader;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
}
