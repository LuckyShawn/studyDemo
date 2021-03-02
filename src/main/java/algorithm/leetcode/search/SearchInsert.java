package algorithm.leetcode.search;

/**
 * @author Shawn  来源：力扣（LeetCode）
 * @title: SearchInsert 35. 搜索插入位置 （二分查找）
 * @projectName studyDemo
 * @description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 通过次数325,175提交次数691,109
 *
 *
 * @date 2021/3/1
 */
public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
    }

    /**
     *  二分查找
     * 	0 ms 100.00%
     * 	38.2 MB 41.81%
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left <= right){   //小于等于
            mid = left + ((right - left) >> 1);   //防止溢出,注意括号
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1; //不能直接=mid
            }else if(nums[mid] > target){
                right = mid -1;
            }
        }
        return left;
    }
}
