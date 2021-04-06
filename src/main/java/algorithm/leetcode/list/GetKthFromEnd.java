package algorithm.leetcode.list;

/**
 * @author Shawn
 * @title: GetKthFromEnd  剑指22. 链表中倒数第k个节点
 * @projectName studyDemo
 * @description: 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * @date 2021/2/19
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode temp = l1;
        while (temp != null) {
            System.out.print("->" + temp.val);
            temp = temp.next;
        }
        temp = getKthFromEnd01(l1, 2);
        System.out.println();
        while (temp != null) {
            System.out.print("->" + temp.val);
            temp = temp.next;
        }
    }

    /**
     * 官解
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            if (former == null) return null;
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    /**
     * 右指针先跑，跑到index=k时，left开始跑，这样当right为null时，left正好是倒数第k个
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了58.35%的用户
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd01(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        int index = 0;
        while (right != null) {
            right = right.next;
            if (index >= k) {
                left = left.next;
            }
            index++;
        }
        return left;
    }

}

