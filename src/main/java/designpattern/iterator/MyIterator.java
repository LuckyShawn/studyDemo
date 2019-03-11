package designpattern.iterator;

/**
 * @Description 自定义的迭代器接口
 * @Author shawn
 * @create 2019/3/11 0011
 */
public interface MyIterator {
    Object first();	//将游标指向第一个元素
    Object next();	//将游标指向下一个元素
    boolean hasNext();//判断是否存在下一个元素

    boolean isFirst();
    boolean isLast();

    Object getCurrentObj();  //获取当前游标指向的对象
}

