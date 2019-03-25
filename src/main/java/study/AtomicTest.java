package study;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description Atomic 类常用方法
 * @Author shawn
 * @create 2019/3/21 0021
 */
public class AtomicTest {
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(100);
        System.out.println(atomicInteger.get());    //100
        atomicInteger.getAndSet(200);
        System.out.println(atomicInteger.get());    //200
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());    //201
        atomicInteger.getAndDecrement();
        System.out.println(atomicInteger.get());    //200
        atomicInteger.getAndAdd(10);
        System.out.println(atomicInteger.get());    //210
        System.out.println(atomicInteger.compareAndSet(210,10));    //true
        System.out.println(atomicInteger.get());    //10
        atomicInteger.lazySet(50);  //lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值
        System.out.println(atomicInteger.get());    //50

        System.out.println("==========================================================");

        int temp = 0;
        int[] arr = {1,2,3,4,5,6,7,8,9};
        AtomicIntegerArray i = new AtomicIntegerArray(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(i.get(j)); //获取 index=i 位置元素的值
        }
        temp = i.getAndSet(0,2); //返回 index=i 位置的当前的值，并将其设置为新值：newValue
        System.out.println("temp:" + temp + ";  i:" + i);
        temp = i.getAndIncrement(0);//获取 index=i 位置元素的值，并让该位置的元素自增
        System.out.println("temp:" + temp + ";  i:" + i);
        temp = i.getAndAdd(0,5);//获取 index=i 位置元素的值，并加上预期的值
        System.out.println("temp:" + temp + ";  i:" + i);


        System.out.println("==========================================================");
        AtomicReference<Person> ar = new AtomicReference<>();
        Person person = new Person("shawn",10);
        ar.set(person);
        System.out.println(ar);
        Person updatePerson = new Person("jack",20);
        ar.compareAndSet(person,updatePerson);
        System.out.println(ar);

        System.out.println("==========================================================");
        AtomicIntegerFieldUpdater<Person> a = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
        person = new Person("Java", 22);
        System.out.println(a.getAndIncrement(person));// 22
        System.out.println(a.get(person));// 23
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}