package algorithm.leetcode.list;

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
        ListNode01 list5 = new ListNode01(5, null);
        ListNode01 list4 = new ListNode01(4, list5);
        ListNode01 list3 = new ListNode01(3, list4);
        ListNode01 list2 = new ListNode01(2, list3);
        ListNode01 list1 = new ListNode01(1, list2);
        reverseList(list1);
        list5 = new ListNode01(5, null);
        list4 = new ListNode01(4, list5);
        list3 = new ListNode01(3, list4);
        list2 = new ListNode01(2, list3);
        list1 = new ListNode01(1, list2);
        reverseList01(list1);
    }

    /**
     * 双指针迭代
     *
     * @param head
     * @return
     */
    public static ListNode01 reverseList(ListNode01 head) {
        ListNode01 cur = null;//当前从null开始
        ListNode01 pre = head;//当前作为上一个节点
        while (pre != null) {
            ListNode01 next = pre.next;    //上一个节点的上一个节点 2
            pre.next = cur;   //上一个节点的 next 指针改为指向当前节点null
            //同时后移一位
            cur = pre;
            pre = next;
        }
        return cur;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode01 reverseList01(ListNode01 head) {
        if (head == null || head.next == null) {    //边界条件  当链表尾部指向null时结束，也就是遍历了一遍链表
            return head;
        }
        ListNode01 p = reverseList01(head.next);
        head.next.next = head;  //此时head.next.next 是null，赋值head，构成了循环链表
        head.next = null;
        return p;
    }
}

class ListNode01 {
    int val;
    ListNode01 next;

    ListNode01() {
    }

    ListNode01(int val) {
        this.val = val;
    }

    ListNode01(int val, ListNode01 next) {
        this.val = val;
        this.next = next;
    }
}
