package algorithm.leetcode.list;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: DeleteDuplicates 82. 删除排序链表中的重复元素 II
 * @projectName studyDemo
 * @description: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * 通过次数103,929提交次数202,115
 * @date 2021/3/25
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(5, new ListNode(9, new ListNode(9, new ListNode(10)))));
        ListNode temp = l1;
        while (temp != null) {
            System.out.print("->" + temp.val);
            temp = temp.next;
        }
        System.out.println();
        temp = deleteDuplicates(l1);
        while (temp != null) {
            System.out.print("->" + temp.val);
            temp = temp.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);  //亚节点
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {  //连续两个节点相等
                int x = cur.next.val;
                while (cur.next != null && x == cur.next.val) {   //判断后续节点是否有相同节点，有相同的则指向相同元素的下一个节点
                    cur.next = cur.next.next;
                }
            } else {//连续两个节点不等，直接指向下一个节点
                cur = cur.next;
            }
        }
        return dummy.next;

    }

    public static ListNode test(ListNode head) {
        if (head == null) {
            return head;
        }
        //定义亚节点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next != null && x == cur.next.val){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
