package designpattern.command;

/**
 * @Description 调用者
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Invoke {
    private Command commond; //可以通过容器容纳大量命令，批量处理。数据库底层

    public Invoke(Command commond) {
        this.commond = commond;
    }
    //业务方法，用于调用命令类的方法
    public void call(){
        commond.execute();
    }

}
