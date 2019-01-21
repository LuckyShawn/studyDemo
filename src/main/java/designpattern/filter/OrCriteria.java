package designpattern.filter;

import java.util.List;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class OrCriteria implements Criteria{
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }


    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> list = criteria.meetCriteria(persons);
        List<Person> otherList = otherCriteria.meetCriteria(persons);
        for (Person person : otherList) {
            if(list.contains(person)){
                list.add(person);
            }
        }
        return list;
    }
}
