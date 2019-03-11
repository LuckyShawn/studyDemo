package designpattern.iterator;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Client {
    public static void main(String[] args){
        ConcreteMyAggregate concreteMyAggregate = new ConcreteMyAggregate();
        concreteMyAggregate.addObject("111");
        concreteMyAggregate.addObject("222");
        concreteMyAggregate.addObject("333");

        //获取迭代器
        MyIterator myIterator = concreteMyAggregate.createIterator();

        while (myIterator.hasNext()){
            System.out.println(myIterator.getCurrentObj());
            myIterator.next();
        }

    }
}
