package remember;

import java.util.ArrayList;
import java.util.List;

/**
 * 容易混淆的点
 * java 中的 length 属性是针对数组说的,比如说你声明了一个数组,想知道这个数组的长度则用到了 length 这个属性.
 * java 中的 length() 方法是针对字符串说的,如果想看这个字符串的长度则用到 length() 这个方法.!
 * java 中的 size() 方法是针对泛型集合说的,如果想看这个泛型有多少个元素,就调用此方法来查看!
 */
public class LengthAndSize {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3};

        String str = "123";

        List list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(arr.length);
        System.out.println(str.length());
        System.out.println(list.size());
    }
}
