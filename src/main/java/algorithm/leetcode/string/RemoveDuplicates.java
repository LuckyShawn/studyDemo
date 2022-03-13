package algorithm.leetcode.string;

import java.util.Stack;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: RemoveDuplicates 1047. 删除字符串中的所有相邻重复项 （easy）(栈解决)
 * @projectName studyDemo
 * @description: 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "ThreadPool" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * 通过次数58,193提交次数80,310
 *
 *
 * @date 2021/3/9
 */
public class RemoveDuplicates {


    public static void main(String[] args) {

    }

    /**
     * 执行用时：23 ms, 在所有 Java 提交中击败了62.07%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了60.14%的用户
     * @param S
     * @return
     */
    public String removeDuplicates01(String S) {
        Stack<Character> stack = new Stack<>();
        char[] s = S.toCharArray();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if(stack.isEmpty() || stack.peek() != s[i]){
                stack.push(s[i]);
            }else{
                stack.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 官解
     * 执行用时：14 ms, 在所有 Java 提交中击败了75.40% 的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了 38.94%
     * 的用户
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }


}
