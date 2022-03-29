package algorithm.leetcode.hard;

import algorithm.leetcode.list.ListNode;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/19 0019
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);   //伪节点
        dummy.next = head;

        ListNode pre = dummy;   //前一个节点
        ListNode end = dummy;   //结束节点

        while (end.next != null){   //结束节点没有下一个节点才结束
            for (int i = 0;i < k && end !=null ;i++){ //获取子链表的结尾
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode start = pre.next;  //存储开始节点
            ListNode next = end.next;   //存储下一个节点，为了反转后能拼接上
            end.next = null;//断开与后面不需要翻转的链表
            pre.next = reverse(start);//pre节点直接指向翻转后的节点（其实是翻转前的start节点）
            start.next = next;//将翻转后的链表拼接到未翻转链表的头结点
            pre = start;    //pre移动到翻转后链表的末尾（是start）
            end = pre;  //end也移动到翻转后链表的末尾（start也是pre）
        }


        return dummy.next;
    }

    /**
     * 翻转链表（结束条件是cur ！= null，存cur.next）
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
