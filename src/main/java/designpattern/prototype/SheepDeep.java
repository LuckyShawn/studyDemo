package designpattern.prototype;

import java.util.Date;

/**
 * @Description 克隆羊类
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class SheepDeep implements Cloneable{
    private String name;
    private Date birthday;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();   //直接调用object对象的clone();
        //添加代码实现深克隆
        SheepDeep s = (SheepDeep) obj;
        s.birthday = (Date) this.birthday.clone();  //把属性也进行克隆
        return obj;
    }


    public SheepDeep() {
    }

    public SheepDeep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
