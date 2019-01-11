package map;

import java.util.*;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public class TreeLinkedHashMap {
    public static void main(String[] args) {
        //TreeMap会自动排序
        Map map = new TreeMap<>();
        map.put(1, 1);
        map.put(3, 1);
        map.put(100, 1);
        map.put(200, 1);
        map.put(50, 1);
        System.out.println(map);
        //LinkedHashMap会记录插入顺序
        map = new LinkedHashMap();
        map.put(1, 1);
        map.put(3, 1);
        map.put(100, 1);
        map.put(200, 1);
        map.put(50, 1);
        System.out.println(map);

        Set set = new HashSet();
        set.add("a");
        System.out.println(set);
    }
}
