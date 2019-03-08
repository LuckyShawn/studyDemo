package designpattern.chainofresponsibility;

/**
 * @Description 请假请求类
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class LeaveRequest {
    private String EmpName;
    private Integer leaveDays;
    private String reason;

    public LeaveRequest(String empName, Integer leaveDays, String reason) {
        EmpName = empName;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
