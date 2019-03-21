package study;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description 通过反射修改String
 * @Author shawn
 * @create 2019/3/21 0021
 */
public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 创建字符串"Hello World"， 并赋给引用s
        String s = "Hello World";

        System.out.println("s = " + s); // Hello World

        // 获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        // 改变value属性的访问权限
        valueFieldOfString.setAccessible(true);

        // 获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);

        // 改变value所引用的数组中的第5个字符
        value[5] = '_';

        System.out.println("s = " + s); // Hello_World

    }
}
