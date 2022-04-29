package algorithm.leetcode.leetCodeTop.mid;

/**
 * @author Shawn
 * @title: SortList 148. 排序链表
 * @projectName studyDemo
 * @description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 输入：head = []
 * 输出：[]
 * @date 2022/4/26
 */
public class SortList {
    /**
     * 自底向上归并排序
     * TOP
     * 1.获取链表长度
     * 2.每次拆分若干个链表，logn时间
     * 3.遍历链表，按照拆分出链表1和2
     * 4.链表1和链表2要断开，链表2和后续链表要断开
     * 5.合并链表1和2
     * 6.合并完成后，用一个新的节点pre链接起来，并遍历到合并链表后端，继续拆分合并下一个子链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        int length = 0;
        ListNode node = head;
        //1.获取链表长度
        while(node !=null){
            length++;
            node = node.next;
        }
        ListNode dummy = new ListNode(0,head);
        //2.每次拆分成若干个子链表，时间复杂度是logn
        for (int subLength = 1; subLength < length; subLength <<= 1) {  //subLength <<= 1 表示左移一位并赋值（即sublen = sublen*2） PS:位运算对CPU来说效率更高
            ListNode pre = dummy;
            ListNode cur = dummy.next;   // curr用于记录拆分链表的位置
            while(cur != null){
                //3.拆分链表1
                ListNode head1 = cur;// 第一个链表的头 即 curr初始的位置
                for (int i = 1; i < subLength && cur != null  && cur.next != null; i++) {  // 拆分出长度为subLen的链表1
                    cur = cur.next;
                }
                //4.拆分链表2  ***重点理解
                ListNode head2 = cur.next; // 第二个链表的头  即 链表1尾部的下一个位置
                cur.next = null; // 断开第一个链表和第二个链表的链接
                cur = head2;    //第二个链表头 重新赋值给cur
                for (int i = 1; i < subLength && cur != null && cur.next !=null; i++) { // 再拆分出长度为subLen的链表2
                    cur = cur.next;
                }

                // 5.再次断开 第二个链表最后的next的链接
                ListNode next = null;
                if(cur != null){
                    next = cur.next; // next用于记录 拆分完两个链表的结束位置，因为合并后还要接回来
                    cur.next = null; // 断开连接
                }

                // 6.合并两个subLen长度的有序链表
                ListNode mergeList = merge(head1,head2);
                pre.next = mergeList; // pre.next 指向排好序链表的头
                while(pre.next != null){  // while循环 将prev移动到 subLen*2 的位置后去
                    pre = pre.next;
                }
                cur = next;  // next用于记录 拆分完两个链表的结束位置，也就是cur是在合并后链表的末尾
            }
        }
       return dummy.next;
    }

    /**
     * 合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
















