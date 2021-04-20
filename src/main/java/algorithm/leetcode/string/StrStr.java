package algorithm.leetcode.string;

/**
 * @author Shawn   * 来源：力扣（LeetCode）
 * @title: StrStr  28. 实现 strStr()
 * @projectName studyDemo
 * @description: 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * 通过次数339,571提交次数849,189
 *
 * @date 2021/4/20
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("qqqqwwww","wwww"));
    }


    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了52.97%的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了87.31%
     * 的用户
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int hayLength  =  haystack.length();
        int needLength = needle.length();
        for (int i = 0; i + needLength <= hayLength; i++) {
            boolean flag = true;
            for (int j = 0; j < needLength; j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    flag = false;
                    break;
                }

            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
