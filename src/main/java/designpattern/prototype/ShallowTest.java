package designpattern.prototype;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 浅克隆复制       复制的引用指向的对象被修改了，克隆的对象的属性也被修改
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class ShallowTest {
    public static void main(String[] args) throws Exception{
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1997-01-01");
        Sheep s1 = new Sheep("少利",date);
        Sheep s2 = (Sheep)s1.clone();
        System.out.println(s1);
        date.setTime(1000000000000L);    //改变引用指向的对象
        System.out.println(date);

        System.out.println(s1==s2); //false不是同一个对象
        s2.setName("中利");   //改变属性不影响原型对象
        System.out.println(s2);
    }
}
