package study.compare;

/**
 * @author Shawn
 * @title: Person
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/4/9
 */
public class Person implements Comparable<Person>{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Person person) {
        return this.getAge() - person.getAge();
    }
}
