package algorithm.leetcode.leetCodeTop.mid;

/**
 * @author Shawn
 *  来源：力扣（LeetCode）
 * @title: LengthOfLIS 300. 最长递增子序列 mid
 * @projectName studyDemo
 * @description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * @date 2022/3/7
 */

public class LengthOfLIS {

    public static void main(String[] args) {
        System.out.println( lengthOfLIS(new int[]{7,7,7,7,8,7,7}));
    }

    /**
     * TOP
     * 1.边界条件
     * 2.状态转移方程：dp[i] = Math.max(dp[i],dp[j] + 1)  dp[i]含义是：i坐标之前的最长递增子序列
     * 对比过程中，只要出现nums[i] > nums[j] 的情况，取dp[i] 和dp[j] +1 中的较大值
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int ans = 0;
        int[] dp = new int[nums.length];// 以第 i 个数字结尾的最长上升子序列的长度

        //初始化，边界情况
        dp[0] = 1;
        //自底向上遍历
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            //从下标0开始遍历i
            for (int j = 0; j < i; j++) {
                //找到前面比nums[i]小的数nums[j],即dp[i] = dp[j] + 1
                if(nums[j] < nums[i]){
                    //有多个小于nums[i]的值，有多种组合，取最大值dp[i]
                    dp[i] = Math.max(dp[i],dp[j] + 1);//状态转移方程：j每次+1，nums[j]都与nums[i]比较，如果小于，则在之前最长子序列的基础上+1，然后取最大的
                }
            }
            //最大dp[i]就是答案
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}
