package algorithm.leetcode.queue;

import java.util.Stack;

/**
 * @author Shawn
 * @title: MyQueue  232. 用栈实现队列 （栈模拟队列，push 2弹1，放值，1弹2）
 * @projectName studyDemo
 * @description: 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *  
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *  
 *
 * 进阶：
 *
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *  
 *
 * 提示：
 *
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * @date 2021/2/25
 */
public class MyQueue {
    Stack<Integer> stack01;
    Stack<Integer> stack02;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack01 = new Stack<Integer>();
        stack02 = new Stack<Integer>();
    }

    private int front;  //前端
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack01.isEmpty()){  //  当栈01是空时，即为队列的第一个数，最先出
            front = x;
        }
        while(!stack01.isEmpty()){  //先将栈01的数据全部弹出到栈02，  2，1 --》 1，2
            stack02.push(stack01.pop());
        }
        stack02.push(x);    //将3 压入栈02，形成 1，2，3
        while(!stack02.isEmpty()){  //再将栈02的数据全部弹出到栈01，形成3，2，1
            stack01.push(stack02.pop());
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int pop = stack01.pop();
        if(!stack01.isEmpty()){
            front = stack01.peek();
        }
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack01.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */