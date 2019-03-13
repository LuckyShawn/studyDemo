package designpattern.memento;

/**
 * @Description 源发器类
 * @Author shawn
 * @create 2019/3/13 0013
 */
public class Emp {

    private String name;
    private int age;
    private double salary;

    //进行备忘操作，并返回备忘录对象
    public EmpMemento menento(){
        return new EmpMemento(this);
    }

    //进行数据恢复，恢复成指定备忘录对象的值
    public void recovery(EmpMemento emp){
        this.name = emp.getName();
        this.age = emp.getAge();
        this.salary = emp.getSalary();
    }

    public void recoveryStack(EmpMemento emp){
        this.name = emp.getName();
        this.age = emp.getAge();
        this.salary = emp.getSalary();
    }


    public Emp(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
