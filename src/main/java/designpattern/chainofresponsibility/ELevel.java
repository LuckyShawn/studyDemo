package designpattern.chainofresponsibility;

/**
 * @Description E级领导
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class ELevel extends Leader{


    public ELevel(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays()<3){
            System.out.println(request.getEmpName()+",请假："+request.getLeaveDays()+",原因："+request.getReason());
            System.out.println("D级领导："+this.name+",审核通过！");
        }else{
            if(this.nextLeader!=null)
            this.nextLeader.handleRequest(request);
        }
    }
}
