package algorithm.leetcode.leetCodeTop.mid;



/**
 * @author Shawn
 * @title: DeleteDuplicates 82. 删除排序链表中的重复元素 II
 * @projectName studyDemo
 * @description:
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * @date 2022/4/25
 */
public class DeleteDuplicates {
    /**
     * TOP
     * 1.head为空则空
     * 2.循环结束条件，下一个和下下个不能为空
     * 3.下一个节点和下下个节点值相等，再判断是否有连续重复的节点
     * 4.下一个节点和下下个节点值不相等，正常遍历即可
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next !=null){   //下个节点和下下个节点不为空的情况才对比
            if(cur.next.val == cur.next.next.val){    //下一个节点和下下个节点值相同
                int temp = cur.next.val;
                while(cur.next != null && temp == cur.next.val){//去除连续重复的情况
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;//不等则正常遍历
            }
        }
        return dummy.next;
    }
}
