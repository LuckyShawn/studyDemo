package algorithm.leetcode.queue;

import java.util.Stack;

/**
 * @author Shawn
 * @title: HelloQueue
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/3/5
 */
public class HelloQueue {
    Stack<Integer> stack01;
    Stack<Integer> stack02;
    public static void main(String[] args) {

    }
    public HelloQueue(){
        stack01 = new Stack();
        stack02 = new Stack();
    }

    private int front;
    public void push(int x){
        if(stack01.isEmpty()){
            front = x;
        }
        while(!stack01.isEmpty()){
            stack02.push(stack01.pop());
        }
        stack02.push(x);
        while (!stack02.isEmpty()){
            stack01.push(stack02.pop());
        }
    }

    public int pop(){
        int element = stack01.pop();
        if(!stack01.isEmpty()){
            front = stack01.peek();
        }
        return element;
    }
}
