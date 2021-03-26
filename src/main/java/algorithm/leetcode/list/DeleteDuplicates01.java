package algorithm.leetcode.list;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: DeleteDuplicates01 83. 删除排序链表中的重复元素
 * @projectName studyDemo
 * @description: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * 通过次数205,270提交次数390,630
 * @date 2021/3/26
 */



public class DeleteDuplicates01 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(5,new ListNode(9,new ListNode(9,new ListNode(10)))));
        ListNode temp = l1;
        temp = deleteDuplicates(l1);
        while(temp != null){
            System.out.print("->" + temp.val  );
            temp = temp.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val){//相等，下一个节点指向下下个节点
                cur.next = cur.next.next;
            }else{//不等直接指向下一个节点
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
