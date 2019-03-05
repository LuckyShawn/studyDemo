package designpattern.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 克隆羊类
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class Sheep implements Cloneable,Serializable {
    private String name;
    private Date birthday;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();   //直接调用object对象的clone();
    }


    public Sheep() {
    }

    public Sheep(String name, Date birthday) {
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
