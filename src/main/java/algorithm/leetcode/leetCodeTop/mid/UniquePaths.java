package algorithm.leetcode.leetCodeTop.mid;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: UniquePaths 62. 不同路径 （动态规划）
 * @projectName studyDemo
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 * @date 2022/2/16
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //左侧第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        //上边第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //动态转移方程：移动到[i][j]的路径数=移动到[i-1][j] + 移动到[i][j-1] 路径数总和
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return  dp[m-1][n-1];

    }
}
