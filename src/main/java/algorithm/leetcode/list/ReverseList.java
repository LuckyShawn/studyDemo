package algorithm.leetcode.list;

import java.util.List;

/**
 * @author Shawn
 * @title: ReverseList  206. 反转链表
 * @projectName studyDemo
 * @description: 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 假设链表为 1→2→3→∅，我们想要把它改成  ∅←1←2←3。  3→2→1→∅
 * <p>
 * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
 * @date 2021/2/20
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(5, new ListNode(9, new ListNode(9, new ListNode(10)))));
        ListNode temp = l1;
        while (temp != null) {
            System.out.print("->" + temp.val);
            temp = temp.next;
        }
        System.out.println();
        temp = l1;

        temp = reverseList01(temp);

        while (temp != null) {
            System.out.print("->" + temp.val);
            temp = temp.next;
        }
    }

    /**
     * 双指针迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //当前从null开始
        ListNode cur = null;
        //原头节点作为上一个节点
        ListNode pre = head;
        while(pre != null){
            ListNode next = pre.next;//先将原链表的下一个节点保存下来
            pre.next = cur;//反转
            cur = pre;//指针后移
            pre = next;//指针后移
        }
        return cur;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList01(ListNode head) {
        if (head == null || head.next == null) {    //边界条件  当链表尾部指向null时结束，也就是遍历了一遍链表
            return head;
        }
        ListNode p = reverseList01(head.next);
        head.next.next = head;  //此时head.next.next 是null，赋值head，构成了循环链表
        head.next = null;
        return p;
    }

    public ListNode test(ListNode head){
        //最前面的指针是null（虚拟指针）
        ListNode pre = null;
        //当前从头开始
        ListNode cur = head;
        while(cur != null){
            //记录下当前的下一个，以便后移
            ListNode next = cur.next;
            cur.next = pre;//反转，当前的下一个指向前一个
            pre = cur;//指针后移，前一个到当前
            cur = next;//指针后移，当前到下一个
        }
        return pre;
    }
}


