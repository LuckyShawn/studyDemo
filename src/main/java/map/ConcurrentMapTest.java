package map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/14 0014
 */
public class ConcurrentMapTest {
    public static void main(String[] args){
        ConcurrentMap concurrentMap = new ConcurrentHashMap();
        List list = new ArrayList<String>();
        Map map = new HashMap<String,String>();
        map.put("AA","AA");
        map.put("BB","BB");
        map.put("CC","CC");
        map.put("DD","DD");
        Iterator<Map.Entry> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = it.next();
            System.out.println(entry.getKey().toString() + entry.getValue().toString());
        }
    }
}
