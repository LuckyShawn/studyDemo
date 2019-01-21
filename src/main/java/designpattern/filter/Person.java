package designpattern.filter;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name,String gender,String maritalStatus){
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                '}';
    }

    public String getGender() {
        return gender;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }


}
