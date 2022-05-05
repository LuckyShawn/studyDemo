package algorithm.leetcode.leetCodeTop.mid;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: LongestCommonSubsequence  1143. 最长公共子序列
 * @projectName studyDemo
 * @description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * @date 2022/4/29
 */
public class LongestCommonSubsequence {
    /**
     * 动态规划 最长公共子序列
     * 1、初始化数组值为0，dp[i][j]表示 text1[0:i]和text2[0:j]的最长公共子序列长度 text1[0:i]表示text1的长度为i的前缀
     * 2、从i=1,j=1开始循环
     * 3、转移方程：字符相等dp[i - 1][j - 1] +1为解，字符不等取前面最大值：Math.max(dp[i - 1][j],dp[i][j - 1])
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; //初始化数组值为0，dp[i][j]表示 text1[0:i]和text2[0:j]的最长公共子序列长度 text1[0:i]表示text1的长度为i的前缀
        for (int i = 1; i <= m; i++) {  //dp[0][0] = 0; 从1开始    当i=0或j=0时，字符串为空，空字符串和任意字符串的最长公共子序列都是0
            char ch1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {  //dp[0][0] = 0; 从1开始
                char ch2 = text2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;    //如果相等，dp[i][j]取左上角值+1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
