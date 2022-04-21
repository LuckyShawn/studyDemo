package algorithm.leetcode.leetCodeTop.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shawn
 * @title: MyQueue 232. 用栈实现队列
 * @projectName studyDemo
 * @description: TODO
 * @date 2022/4/20
 */
public class MyQueue {
    /**
     * TOP
     * 入队时直接放入in栈，出队时从out栈中取，如果out栈空，将in栈弹出到out栈
     * 当in、out栈都为空，则队列为空
     */
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new ArrayDeque();
        outStack = new ArrayDeque();
    }

    /**
     * 摊还分析给出了所有操作的平均性能。摊还分析的核心在于，最坏情况下的操作一旦发生了一次，那么在未来很长一段时间都不会再次发生，这样就会均摊每次操作的代价。
     * 如果输出栈为空时，才将输入栈中的数据压入输出栈
     */
    public void in2Out(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
    private int front;  //前端
    /** Push element x to the back of queue. */
    public void push(int x) {
       inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2Out();
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        in2Out();
        return outStack.peek();
    }


    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
