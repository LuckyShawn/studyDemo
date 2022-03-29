package algorithm.leetcode.easy;

import algorithm.leetcode.list.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/21 0021
 */
public class HasCycle {
    public static void main(String[] args) {


    }

    /**
     * 哈希表 遍历节点
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head)) {   //遍历链表，有被访问过的，就返回true，指针往后
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针，龟兔赛跑算法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //边界
        if (head == null || head.next == null) {
            return false;
        }
        //定义快慢指针
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) { //快指针走完说明没有环形
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
