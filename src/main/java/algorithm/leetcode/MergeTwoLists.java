package algorithm.leetcode;

/**
 * @author Shawn
 * @title: MergeTwoLists
 * @projectName studyDemo
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date 2020/11/9
 */

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
            System.out.println(temp.val);
            temp = temp.next;
        }

        temp = mergeTwoLists(l1, l2);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }



    }

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
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
