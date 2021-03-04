package algorithm.leetcode.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: StringPartition  131. 分割回文串 （回溯）
 * @projectName studyDemo
 * @description: 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * 通过次数65,625提交次数93,177
 *
 * @date 2021/3/4
 */
public class StringPartition {

    public static void main(String[] args) {
        StringPartition stringPartition = new StringPartition();
        System.out.println(stringPartition.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack, res);
        return res;
    }

    /**
     * @param charArray
     * @param index     起始字符的索引
     * @param len       字符串 s 的长度，可以设置为全局变量
     * @param path      记录从根结点到叶子结点的路径
     * @param res       记录所有的结果
     */
    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.removeLast();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
     *
     * @param charArray
     * @param left      子串的左边界，可以取到
     * @param right     子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


/**
 每一个结点表示剩余没有扫描到的字符串，产生分支是截取了剩余字符串的前缀；
 产生前缀字符串的时候，判断前缀字符串是否是回文。
 如果前缀字符串是回文，则可以产生分支和结点；
 如果前缀字符串不是回文，则不产生分支和结点，这一步是剪枝操作。
 在叶子结点是空字符串的时候结算，此时 从根结点到叶子结点的路径，就是结果集里的一个结果，使用深度优先遍历，记录下所有可能的结果。
 使用一个路径变量 path 搜索，path 全局使用一个（注意结算的时候，要生成一个拷贝），因此在递归执行方法结束以后需要回溯，即将递归之前添加进来的元素拿出去；
 path 的操作只在列表的末端，因此合适的数据结构是栈。
 */