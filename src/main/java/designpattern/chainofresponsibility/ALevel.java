package designpattern.chainofresponsibility;

/**
 * @Description E级领导
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class ALevel extends Leader{


    public ALevel(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays()<30){
            System.out.println(request.getEmpName()+",请假："+request.getLeaveDays()+",原因："+request.getReason());
            System.out.println("A级领导："+this.name+"，审核通过！");
        }else{
            System.out.println("请假天数过长，审核不通过！");
        }
    }
}
