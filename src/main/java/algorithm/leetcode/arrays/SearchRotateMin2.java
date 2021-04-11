package algorithm.leetcode.arrays;

/**
 * @author Shawn   * 来源：力扣（LeetCode）
 * @title: SearchRotateMin2 154. 寻找旋转排序数组中的最小值 II （hard）
 * @projectName studyDemo
 * @description: 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,5]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *  
 *
 * 进阶：
 *
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * 通过次数64,682提交次数125,212
 *
 * @date 2021/4/9
 */


public class SearchRotateMin2 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{6,5,4,3,2,1,0}));
        System.out.println(findMin(new int[]{1}));
        System.out.println(findMin(new int[]{6,5,5,5,2,1,0}));
    }

    public static int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = left + ((right - left ) >> 1);
            if(nums[right] > nums[mid]){    //右侧大于中值，最小值在中值左侧
                right = mid;
            }else if(nums[right] < nums[mid]){  //右侧小于中值，最小值在中值右侧
                left = mid + 1;
            }else{  //如果右侧与mid相等，则直接跳过
                right -= 1;
            }
        }
        return nums[left];
    }
}
