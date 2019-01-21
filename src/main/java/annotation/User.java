package annotation;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/16 0016
 */
public class User {

    @Validate(min = 1,max = 10)
    private String name;

    @Validate(isNotNull = true)
    private Integer age;

    public String getName() {
        return name;
    }

    @Init(value = "shawn")
    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            System.out.println(""+i);
        }
    }
}
