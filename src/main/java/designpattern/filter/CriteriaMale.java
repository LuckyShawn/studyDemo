package designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 女性
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class CriteriaMale implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> list = new ArrayList<Person>();  ;
        for (Person person : persons) {
            if("male".equalsIgnoreCase(person.getGender())){
                list.add(person);
            }
        }
        return list;
    }
}
