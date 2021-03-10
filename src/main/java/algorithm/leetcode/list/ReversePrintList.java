package algorithm.leetcode.list;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 通过次数169,972提交次数225,667
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePrintList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(5);
        ListNode l111 = new ListNode(9);
        l1.next = l11;
        l11.next = l111;
        ListNode temp = l1;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(Arrays.toString(reversePrint(l1)));
    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] reverseInt = new int[size];
        for (int i=0;i < size;i++){
            reverseInt[i] = stack.pop().val;
        }
        return reverseInt;
    }
}
