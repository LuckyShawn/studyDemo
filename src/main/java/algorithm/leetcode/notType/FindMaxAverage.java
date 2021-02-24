package algorithm.leetcode.notType;

/**
 * @author Shawn
 * @title: FindMaxAverage 子数组最大平均数 I  (滑动窗口)
 * @projectName studyDemo
 * @description: 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 提示：
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * @date 2021/2/4
 */
public class FindMaxAverage {
    public static void main(String[] args) {
       // System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverage(new int[]{9,7,3,5,6,2,0,8,1,9},6));
        //System.out.println(findMaxAverage(new int[]{5},1));
    }

    public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        int len = nums.length;

        for(int i = 0 ; i < k ;i++){    //前k个数的和 （创建窗口）
            sum += nums[i];
        }
        if(k == len){
            return 1.0 * sum / k;   //如果k刚好是数组长度，直接求平均值返回
        }

        int maxSum = sum;
        for(int i = k;i < len;i++){
            sum += nums[i] - nums[i - k];   //滑动窗口，右边界往后一个，左边界往后一个（表达式中的差值）
            maxSum = Math.max(maxSum,sum);  //每个窗口中的值做对比取最大值
        }
        return 1.0 * maxSum / k;
    }

}
