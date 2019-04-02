package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author shawn
 * @create 2019/1/28 0028
 */
public class CollectionTest {
    public static void main(String[] args){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("4");
        list1.addAll(list2);
        System.out.println(list1);
        System.out.println(list1.size());
    }
}
