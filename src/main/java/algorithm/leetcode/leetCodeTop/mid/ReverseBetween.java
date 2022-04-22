package algorithm.leetcode.leetCodeTop.mid;

import algorithm.leetcode.list.ListNode;

import java.util.List;

/**
 * @author Shawn
 * @title: ReverseBetween
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @projectName studyDemo
 * @description: 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * @date 2022/4/13
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        list = new ReverseBetween().reverseBetween(list, 3, 5);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

    }


    /**
     * TOP
     * 1->2->3->4->5->6   ---》    1->2->5->4->3->6
     * 迭代法：
     * 0.准备：需要虚拟头节点（返回结果）和pre节点（用于操作）
     * 1.先走到left前一个节点
     * 2.rightNode记录最后一段链表，rightNode走right - left + 1 到right节点
     * 3.leftNode记录截取子链表，leftNode走
     * 4.
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;//虚拟头节点指向head
        ListNode pre = dummyNode;//pre节点用于操作，dummy节点用于返回结果
        //走到left前一个节点，来到left-1的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;//保存right索引中的节点，从 pre 再走 right - left + 1 步，来到 right 节点
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;   //获取子链表的开始节点
        ListNode curr = rightNode.next;//当前迭代到的位置，子链表反转后需要拼接的右边
        pre.next = null;
        rightNode.next = null;
        //反转
        reverseLinkedList(leftNode);
        //接回
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }


    /**
     * 反转
     *
     * @param head
     * @return
     */
    public ListNode reverseLinkedList(ListNode head) {
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = next;
        }
        return cur;
    }
}
