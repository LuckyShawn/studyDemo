package collection;


import algorithm.leetcode.list.ListNode;

/**
 * @Description 链表中倒数第k个节点
 * @Author shawn
 * @create 2019/3/25 0025
 */
public class LinkedAfterK {

    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        list1.next = list2;
        ListNode list3 = new ListNode(3);
        list2.next = list3;
        ListNode list4 = new ListNode(4);
        list3.next = list4;
        ListNode list5 = new ListNode(5);
        list4.next = list5;
        ListNode list6 = new ListNode(6);
        list5.next = list6;
        ListNode list7 = new ListNode(7);
        list5.next = list7;


        //ListNode result = new LinkedAfterK().FindKthToTail(list1,3);
        ListNode result = new LinkedAfterK().FindKthToTail01(list1,3);
        System.out.println(result.val);

    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode pre=null,p=null;
        //两个指针都指向头结点
        p=head;
        pre=head;
        //记录k值
        int a=k;
        //记录节点的个数
        int count=0;
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while(p!=null){
            p=p.next;
            count++;
            if(k<1){
                pre=pre.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if(count<a) return null;
        return pre;

    }

    /**
     * 统计总节点数index，再取 index - k个节点即可
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了73.09%的用户
     * @param head
     * @param k
     * @return
     */
    public  static ListNode FindKthToTail01(ListNode head, int k) {
        ListNode temp = head;
        int index = 0;
        while(temp != null){
            index++;
            temp = temp.next;
        }
        int tailIndex = 0;
        while(head != null){
            if((index - k) == tailIndex++ ){
                break;
            }else{
                head = head.next;
            }

        }
        return head;
    }
}

