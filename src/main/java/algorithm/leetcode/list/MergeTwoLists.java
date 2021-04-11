package algorithm.leetcode.list;

/**
 * @author Shawn
 * @title: MergeTwoLists
 * @projectName studyDemo
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date 2020/11/9
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(5);
        ListNode l111 = new ListNode(9);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(2);
        ListNode l22 = new ListNode(3);
        ListNode l222 = new ListNode(10);
        l2.next = l22;
        l22.next = l222;

        ListNode temp = l1;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        temp = l2;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
        //temp = mergeTwoLists01(l1, l2);
        temp = mergenListTest(l1, l2);

        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }



    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 暴力迭代解法
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了54.79%的用户
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
        ListNode prehead = new ListNode(-1);//亚节点
        ListNode prev = prehead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;//移动亚节点，准备下一次比较
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }


    public static ListNode mergenListTest(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                pre.next = l2;
                l2 = l2.next;
            }else{
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}


