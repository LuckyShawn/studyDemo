package algorithm.leetcode.list;

/**
 * @author Shawn
 * @title: GetKthFromEnd  剑指22. 链表中倒数第k个节点
 * @projectName studyDemo
 * @description: 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 * @date 2021/2/19
 */
public class GetKthFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode01 getKthFromEnd(ListNode01 head, int k) {
        ListNode01 former = head, latter = head;
        for(int i = 0; i < k; i++) {
            if(former == null) return null;
            former = former.next;
        }
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }


}

class ListNode {
    int val;
    ListNode01 next;
    ListNode(int x) { val = x; }
}
