package designpattern.filter;

import java.util.List;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
