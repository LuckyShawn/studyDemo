package designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
