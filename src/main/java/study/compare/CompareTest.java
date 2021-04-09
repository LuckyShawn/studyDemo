package study.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Shawn
 * @title: CompareTest  测试Comparable和Comparator接口
 * Comparable：内部比较器，需要修改实体源码
 * Comparator：外部比较器，直接实现
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/4/9
 */
public class CompareTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person(10,"A"));
        list.add(new Person(2,"B"));
        list.add(new Person(16,"C"));
        list.add(new Person(20,"D"));
        list.add(new Person(8,"E"));
        list.sort(null);
        //正序
        for (Person person : list){
            System.out.println(person.getAge());
        }

        //倒序
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for (Person person : list){
            System.out.println(person.getAge());
        }


    }
}
