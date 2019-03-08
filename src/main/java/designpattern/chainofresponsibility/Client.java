package designpattern.chainofresponsibility;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class Client {
    public static void main(String[] args){
        Leader e = new LeaderChain().getE();
        LeaveRequest leaveRequest = new LeaveRequest("shawn",29,"回家！");
        e.handleRequest(leaveRequest);
    }
}
