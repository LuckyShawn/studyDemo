package algorithm.leetcode.dp;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: ClimbStairs 70. 爬楼梯
 * @projectName studyDemo
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 通过次数388,203提交次数752,536
 *
 * @date 2021/3/16
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 滚动数组求和
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35 MB, 在所有 Java 提交中击败了91.70%的用户
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            //滚动数组
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
