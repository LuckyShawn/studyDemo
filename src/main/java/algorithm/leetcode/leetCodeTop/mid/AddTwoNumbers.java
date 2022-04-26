package algorithm.leetcode.leetCodeTop.mid;

import designpattern.strategy.Add;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shawn
 * @title: AddTwoNumbers 2. 两数相加
 * @projectName studyDemo
 * @description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @date 2022/4/25
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        //输出：[8,9,9,9,0,0,0,1]
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        new AddTwoNumbers().addTwoNumbers(l1, l2);//708
    }

    /**
     * TOP 模拟
     * 前一轮的进位需要在后一轮加上
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {  //或
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;    //需要加上上一轮的进位
            cur.next = new ListNode(sum % 10);  //进位后的余数作为下一个节点链表值
            carry = sum / 10;   //记录进位
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;   //截取
            curr.next = new ListNode(sum % 10); //余数作为下一个节点的值
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
