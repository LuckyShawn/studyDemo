package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author Shawn  来源：力扣（LeetCode）
 * @title: MaxSubArray 53. 最大子序和 (easy)
 * @projectName studyDemo
 * @description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *  
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 通过次数443,720提交次数828,227
 * @date 2021/3/16
 */
public class MaxSubArray {

    public static void main(String[] args) {

    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];  //dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        dp[0] = nums[0];    //边界条件
        for (int i = 1; i < n; i++) {
            if(dp[i - 1] > 0){  //dp中前面的值大于0，则相加，否则丢弃
                dp[i] = dp[i - 1]  + nums[i];
            }else{
                dp[i] = nums[i];
            }
        }
        int ans = dp[0];
        for (int num : dp){
            ans = Math.max(num,ans);
        }
        return ans;
    }

    /**
     * 动态规划--优化空间
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        for (int num : nums){
            pre = Math.max(num,pre + num);  //类似滚动数组，前一个+当前数和前一个比较，大于则取，小于取本身
            ans = Math.max(ans,pre);    //取ans和pre中的最大值
        }
        return ans;
    }


}
