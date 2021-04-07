package algorithm.leetcode.arrays;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: SearchRotateArray 81. 搜索旋转排序数组 II  (mid)
 * @projectName studyDemo
 * @description: 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *  
 * <p>
 * 进阶：
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 通过次数64,485提交次数169,334
 * @date 2021/4/7
 */
public class SearchRotateArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,0,1,1,1},0));
        System.out.println(search01(new int[]{1,0,1,1,1},0));
        System.out.println(search02(new int[]{3,4,5,6,8,1,2,3},2));
    }


    public static boolean search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return nums[0] == target;
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            //处理重复元素问题
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) { //由于重复元素，这种情况无法判断分区，左加1，右减1继续二分
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) { //左侧递增
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {    //
                if (target > nums[mid] && target <= nums[length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }


    public static boolean search02(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return true;
            }
        }
        return false;
    }


    /**
     * 官解
     *
     * @param nums
     * @param target
     * @return
     */
    public static boolean search01(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return nums[0] == target;
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) { //由于重复元素，这种情况无法判断分区，左加1，右减1继续二分
                ++left;
                --right;
            } else if (nums[left] <= nums[mid]) {   //左侧递增
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
