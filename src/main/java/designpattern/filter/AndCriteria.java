package designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class AndCriteria implements Criteria{
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria,Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> list = criteria.meetCriteria(persons);
        List<Person> otherList = otherCriteria.meetCriteria(list);
        return otherList;
    }
}
