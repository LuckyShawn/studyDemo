package designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 男性
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class CriteriaFemale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> list = new ArrayList<Person>();
        for (Person person : persons) {
            if("female".equalsIgnoreCase(person.getGender())){
                list.add(person);
            }
        }

        return list;
    }
}
