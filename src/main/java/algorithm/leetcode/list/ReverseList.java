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
        ListNode cur = null;//当前从null开始
        ListNode pre = head;//当前作为上一个节点
        while (pre != null) {
            ListNode next = pre.next;    //上一个节点的上一个节点 2
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
        ListNode pre = head;
        ListNode cur = null;
        while(pre != null){
            ListNode next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = next;

        }
        return cur;
    }
}


