package study;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yang.xiao
 * @Description:
 * @Date: 2018/11/5 0005 8:40
 **/
public class MapEntry {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("11","11");
        map.put("22","22");

       for( Map.Entry<String,String>  set : map.entrySet()){
           System.out.println(set.getKey()+set.getValue());
       }
    }
}
