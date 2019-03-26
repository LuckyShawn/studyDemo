package collection;

import java.util.Stack;

/**
 * @Description 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Author shawn
 * @create 2019/3/25 0025
 */
public class TwoStackAsQueue {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args){
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);

        while (!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }

    }

    public void push(Integer num){
        stack1.push(num);
    }

    public Integer pop(){
        //如果两个队列都为空则抛出异常,说明用户没有push进任何元素
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        //如果stack2不为空直接对stack2执行pop操作，
        while (!stack1.isEmpty()){
            //将stack1的元素按后进先出push进stack2里面
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

}
