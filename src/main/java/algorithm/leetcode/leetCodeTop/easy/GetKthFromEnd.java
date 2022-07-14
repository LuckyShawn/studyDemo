package algorithm.leetcode.leetCodeTop.easy;

import algorithm.leetcode.list.ListNode;

/**
 * @author Shawn
 * @title: GetKthFromEnd  剑指22. 链表中倒数第k个节点
 * @projectName studyDemo
 * @description: 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * @date 2022/05/05
 */
public class GetKthFromEnd {

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static algorithm.leetcode.list.ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            if(right == null){
                return null;
            }
            right = right.next;
        }
        while(right!= null){
            left = left.next;
            right = right.next;
        }
        return left;
    }

    /**
     * 更优
     * 右指针先跑，跑到index=k时，left开始跑，这样当right为null时，left正好是倒数第k个
     * @return
     */
    public static ListNode getKthFromEnd01(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        int index = 0;
        while(right != null){
            right = right.next;
            if(index >= k){
                left = left.next;
            }
            index++;
        }
        return left;
    }

}
