package algorithm.leetcode.leetCodeTop.mid;

import algorithm.leetcode.list.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: ReorderList
 * @projectName studyDemo
 * @description: 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @date 2022/4/19
 */
public class ReorderList {

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
        new ReorderList().reorderList(list1);
    }

    /**
     * myself ac
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = head;
        Deque<ListNode> deque = new ArrayDeque();//利用双端队列
        while (pre != null) {//将节点先按顺序放入队列
            deque.addLast(pre);
            pre = pre.next;
        }
        dummy.next = head;
        while (!deque.isEmpty()) {
            if (deque.getFirst() != null ) {//取第一个
                dummy.next = deque.pollFirst();
                dummy = dummy.next;
            }
            if(deque.isEmpty()){    //当取完最后一个节点指向null
                dummy.next = null;
                break;
            }
            if (deque.getLast() != null ) {//取最后一个
                dummy.next = deque.pollLast();
                dummy = dummy.next;
            }
            if(deque.isEmpty()){    //当取完最后一个节点指向null
                dummy.next = null;
                break;
            }
        }
    }

    /**
     * 类似的思想，用ArrayList
     * @param head
     */
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * 快慢指针找中点，从中点开始反转链表，原链表和反转链表合并
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    /**
     * 快慢指针找中点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
