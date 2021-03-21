package algorithm.leetcode.string;

/**
 * @Description  28. 实现 strStr()
 * @Authod shawn  * 来源：力扣（LeetCode）
 * @create 2021/3/21 0021
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 通过次数313,423提交次数788,673
 *
 */
public class StrStr      {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needleLength = needle.length();
        for(int start = 0;start < hayLength - needleLength + 1;start++){
            if(haystack.substring(start,start + needleLength).equals(needle)){
                return start;
            }
        }
        return -1;
    }
}
