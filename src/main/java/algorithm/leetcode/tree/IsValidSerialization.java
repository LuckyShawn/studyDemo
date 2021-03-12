package algorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Shawn
 * @title: IsValidSerialization 331. 验证二叉树的前序序列化 (树的前序遍历)
 * @projectName studyDemo
 * @description: 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * <p>
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * <p>
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: "9,#,#,1"
 * 输出: false
 * 通过次数24,404提交次数51,182
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * DLR--前序遍历（根在前，从左往右，一棵树的根永远在左子树前面，左子树又永远在右子树前面 ）
 * <p>
 * LDR--中序遍历（根在中，从左往右，一棵树的左子树永远在根前面，根永远在右子树前面）
 * <p>
 * LRD--后序遍历（根在后，从左往右，一棵树的左子树永远在右子树前面，右子树永远在根前面）
 * @date 2021/3/12
 */
public class IsValidSerialization {
    public static void main(String[] args) {
        System.out.println(isValidSerialization("1001,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization01("1001,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    public static boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字(循环是因为可能是多位数，直到遇到逗号，)
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();

    }

    public static boolean isValidSerialization01(String preorder) {
        int length = preorder.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int i = 0;
        while (i < length) {
            if (stack.isEmpty()) {
                return false;
            }

            if ('#' == preorder.charAt(i)) {//遇到#，少一个槽位
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else if (',' == preorder.charAt(i)) {
                i++;
            } else { //数字，可能是多位，减少一个槽位，补充两个槽位
                while (i < length && ',' != preorder.charAt(i)) {
                    i++;
                }
                int top = stack.pop() - 1;
                if(top > 0){
                    stack.push(top );
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}

/*
我们可以定义一个概念，叫做槽位。一个槽位可以被看作「当前二叉树中正在等待被节点填充」的那些位置。

二叉树的建立也伴随着槽位数量的变化。每当遇到一个节点时：

如果遇到了空节点，则要消耗一个槽位；

如果遇到了非空节点，则除了消耗一个槽位外，还要再补充两个槽位。

此外，还需要将根节点作为特殊情况处理。



我们使用栈来维护槽位的变化。栈中的每个元素，代表了对应节点处剩余槽位的数量，而栈顶元素就对应着下一步可用的槽位数量。当遇到空节点时，仅将栈顶元素减 1；
当遇到非空节点时，将栈顶元素减 1 后，再向栈中压入一个 2。无论何时，如果栈顶元素变为 0，就立刻将栈顶弹出。

遍历结束后，若栈为空，说明没有待填充的槽位，因此是一个合法序列；否则若栈不为空，则序列不合法。此外，在遍历的过程中，若槽位数量不足，则序列不合法。

 */
