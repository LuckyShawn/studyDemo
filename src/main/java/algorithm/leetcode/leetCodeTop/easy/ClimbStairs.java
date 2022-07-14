package algorithm.leetcode.leetCodeTop.easy;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: ClimbStairs 70. 爬楼梯
 * @projectName studyDemo
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * @date 2022/4/22
 */
public class ClimbStairs {
    /**
     *
     * TOP
     * 一、动态规划
     * 边界条件：dp[0] = 1;dp[1] = 1;
     * 转移方程：dp[i] = dp[i - 1] + dp[i - 2];
     *
     * 二、滚动数组
     * 三个数组指针left，right，res
     * left = right;
     * right = res;
     * res = left + right;
     */
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 滚动数组
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int left = 0;
        int right = 0;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            left = right;
            right = res;
            res = left + right;
        }
        return res;
    }
}
