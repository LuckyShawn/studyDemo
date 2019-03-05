package designpattern.prototype;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 原型模式：深克隆
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class DeepTest {
    public static void main(String[] args)throws Exception{
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1997-01-01");
        SheepDeep s1 = new SheepDeep("少利",date);
        SheepDeep s2 = (SheepDeep)s1.clone();
        System.out.println(s1);
        date.setTime(1000000000000L);    //改变引用指向的对象
        System.out.println(date);

        System.out.println(s1==s2); //false不是同一个对象
        s2.setName("中利");   //改变属性不影响原型对象
        System.out.println(s2);
    }
}
