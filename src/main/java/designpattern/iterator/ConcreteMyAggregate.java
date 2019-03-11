package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 自定义聚合类
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<>();

    public void addObject(Object object) {
        this.list.add(object);
    }

    public void remove(Object object) {
        this.list.remove(object);
    }

    public List getList() {
        return this.list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    //获得迭代器
    public MyIterator createIterator() {
        return new ConcreteIterator();
    }

    //使用内部类定义迭代器，可以直接使用外部类的属性
    private class ConcreteIterator implements MyIterator {

        private int index; //定义游标用于记录遍历时的位置

        @Override
        public Object first() {
            return list.get(0);
        }

        @Override
        public Object next() {
            Object obj = null;
            if(index<list.size()){
                obj = list.get(index);
                index++;
            }
            return obj;
        }

        @Override
        public boolean hasNext() {
            return index < list.size() ? true : false;
        }

        @Override
        public boolean isFirst() {
            return index == 0 ? true : false;
        }

        @Override
        public boolean isLast() {
            return index == (list.size() - 1) ? true : false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(index);
        }
    }

}
