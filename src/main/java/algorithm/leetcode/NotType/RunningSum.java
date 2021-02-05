package algorithm.leetcode.NotType;

import java.util.Arrays;

/**
 * @author Shawn
 * @title: RunningSum  1480. 一维数组的动态和
 * @projectName studyDemo
 * @description: 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 *
 * @date 2021/2/4
 */
public class RunningSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum1(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(runningSum1(new int[]{1,1,1,1,1,1})));
        System.out.println(Arrays.toString(runningSum1(new int[]{3,1,2,10,1})));
    }


    public static int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            sum += nums[i];
            sums[i] = sum;
        }
        return sums;
    }

    public static int[] runningSum1(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        int index = 0;
        while (index != nums.length){
            sum += nums[index];
            sums[index] = sum;
            index++;
        }
        return sums;
    }
}
