package algorithm.leetcode.leetCodeTop.mid;

import algorithm.leetcode.list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Shawn
 * @title: RemoveNthFromEnd 19. 删除链表的倒数第 N 个结点
 * @projectName studyDemo
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * @date 2022/4/24
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(6);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        new RemoveNthFromEnd().removeNthFromEnd(list1,3);
    }

    /**
     * TOP
     * 一、栈
     * 1.遍历链表压入栈
     * 2.n次循环获取pre节点
     * 3.pre节点指向删除节点的后一个节点
     * 4.返回虚拟节点的下一个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {//因为从0开始，所以多弹出一个，循环结束后的栈顶是需要删除节点的前一个节点
                stack.pop();
        }
        ListNode pre = stack.peek();//需要删除的前一个节点
        pre.next = pre.next.next;//前一个节点指向需要删除的猴一个节点
        return dummy.next;
    }

    /**
     *  二、通过获取长度删除
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        ListNode pre = dummy;
        for (int i = 0; i < size - n ; i++) {
            pre = pre.next; //到删除前一个
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 三、双指针
     * 1.pre指针，cur指针
     * 2.cur先移动n步，pre再跟着移动知道cur到末尾，相当于pre走了size-n步，即为删除节点的前一个节点
     * 3.pre节点指向删除节点的后一个节点
     * 4.返回虚拟节点的下一个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head;
        ListNode pre = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while(cur != null){
            cur = cur.next;
            pre = pre.next; //相当于走了size - n步
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
