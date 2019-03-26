package collection;

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


        ListNode result = new LinkedAfterK().FindKthToTail(list1,3);
        System.out.println(result.val);

    }

    public ListNode FindKthToTail(ListNode head,int k) {
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
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
