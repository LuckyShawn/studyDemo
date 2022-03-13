package algorithm.leetcode.leetCodeTop.mid;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: MinPathSum 64. 最小路径和 (动态规划)
 * @projectName studyDemo
 * @description:    /** * //动态规划思路：
 *  * 1.确定状态：研究最优策略的最后一步 化成子问题
 *  * 2.状态转移方程：根据子问题可以直接得到
 *  * 3.初始条件和边界情况：细心，考虑周全
 *  * 4.计算顺序：利用之前的计算结果
 *给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 */


public class MinPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];
        dp[0][0] = grid[0][0];//0-0第一格位置的最优解就是本身
        //计算第一列的最优解
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];//等于左一列的值加上该列最上面的值
        }
        //计算第一行的最优解
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];//等于上一行的值加上当前行最左边的值
        }
        //计算剩下的解，从第一行到row-1行，从第一列到col-1列，计算每个位置的最小路径解
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //位置[i][j]的最优解等于左边位置和上方位置较小的解加当前位置的值
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];//右下角的最优解
    }
}
