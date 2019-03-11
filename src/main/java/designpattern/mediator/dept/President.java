package designpattern.mediator.dept;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class President implements Mediator {

    private static Map<String,Dept> map = new HashMap();

    @Override
    public void register(String dname, Dept d) {
        map.put(dname,d);
    }

    @Override
    public void command(String dname) {
        map.get(dname).outAction();
    }
}
