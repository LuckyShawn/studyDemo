package algorithm.leetcode.leetCodeTop.easy;

import algorithm.leetcode.list.ListNode;

/**
 * @author Shawn * 来源：力扣（LeetCode）
 * @title: MergeTwoLists
 * @projectName studyDemo
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date 2022/02/15
 */

public class MergeTwoLists {
    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //终止条件
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode node = new ListNode(-1);//虚拟节点,用于返回结果
        ListNode pre = node;//新的链表，用于生成结果
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                //l1后移一位
                l1 = l1.next;
            }else if(l1.val > l2.val){
                pre.next = l2;
                l2 = l2.next;
            }
            //节点后移
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return node.next;
    }
}
