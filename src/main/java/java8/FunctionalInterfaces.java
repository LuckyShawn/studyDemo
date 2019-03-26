package java8;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/25 0025
 */
public class FunctionalInterfaces {
    public static void main(String[] args){
        // TODO 将数字字符串转换为整数类型
        Converter<String,Integer> converter = (form) -> Integer.valueOf(form);
        Integer integer = converter.convert("255");
        System.out.println(integer.getClass());//class java.lang.Integer类型
        System.out.println(integer);    //255

        //方法和构造函数引用(Method and Constructor References)
        Converter<String,Integer> converter1 = Integer::valueOf;
        integer = converter1.convert("111");
        System.out.println(integer.getClass());//class java.lang.Integer类型
        System.out.println(integer);    //111

        //引用对象方法
        Something something = new Something();
        Converter<String,String> converter2 = something::startsWith;
        String str = converter2.convert("abcde");
        System.out.println(str);    //a

        //构造函数引用关联
        PersonFactory personFactory = Person::new;
        Person person = personFactory.create("shawn","cool");
        System.out.println(person);
    }
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}
//包含多个构造函数的简单类
class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
//创建Person对象的对象工厂接口
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
