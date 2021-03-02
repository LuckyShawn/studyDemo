package algorithm.leetcode.search;

import java.util.Arrays;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: SearchRange 34. 在排序数组中查找元素的第一个和最后一个位置
 * @projectName studyDemo
 * @description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * 通过次数213,067提交次数503,853
 *
 *
 * @date 2021/3/1
 */
public class SearchRange {

    public static void main(String[] args) {
        System.out.println( Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println( Arrays.toString(searchRange01(new int[]{5,7,7,8,8,10},8)));
        System.out.println( Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},6)));
        System.out.println( Arrays.toString(searchRange01(new int[]{5,7,7,8,8,10},6)));
        System.out.println( Arrays.toString(searchRange01(new int[]{1},1)));
    }

    /**
     *  二分查找
     * 	0 ms 100.00%
     * 	42 MB 5.18%
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums,target);
        int right = searchRight(nums,target);
        if(left > right ){
            return new int[]{-1,-1};
        }
        return new int[]{left,right};
    }

    /**
     * 左边界
     * @param nums
     * @param target
     * @return
     */
    public static int searchLeft(int[] nums,int target){
        int left = 0;
        int right = nums.length -1;
        int mid;
        while ( left <= right ) {
           mid = left + ((right - left) >> 1);
           if(target <= nums[mid]){
               //当目标值小于等于nums[mid]时，继续在左区间检索，找到第一个数
               right = mid - 1;
           }else if(target > nums[mid]){
               //目标值大于nums[mid]时，则在右区间继续检索，找到第一个等于目标值的数
               left = mid + 1;
           }
        }
        return left;
    }

    /**
     * 右边界
     * @param nums
     * @param target
     * @return
     */
    public static int searchRight(int[] nums,int target){
        int left = 0;
        int right = nums.length -1;
        int mid;
        while ( left <= right ) {
            mid = left + ((right - left) >> 1);
            if(target >= nums[mid]){
                 left = mid + 1;
            }else if(target < nums[mid]){
                 right = mid - 1;
            }
        }
        return right;
    }

    /**
     *  有点投机取巧了
     *  1 ms	21.03%
     *  41.7 MB 49.31%
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange01(int[] nums, int target) {
        int left = -1;
        int right = -1;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == target){
                if(left != -1){ //左指针不是-1，右指针就随着循环往右移
                    right = i;
                }else{
                    //只要存在有一个数，那么左右指针是先指向同一个索引的
                    left = i;
                    right = i;
                }
            }
        }
        return new int[]{left,right};
    }

}
