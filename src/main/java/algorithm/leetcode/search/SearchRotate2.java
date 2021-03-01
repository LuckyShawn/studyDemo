package algorithm.leetcode.search;

/**
 * 81. 搜索旋转排序数组 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 通过次数54,970提交次数148,572
 *
 * 来源：力扣（LeetCode）
 */
public class SearchRotate2 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{2,5,6,0,0,1,2},3));
    }

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid]  == nums[left] ){
                left ++;
                continue;
            }
            //前半部分有序
            if(nums[left] < nums[mid] ){
                //前半部分找
                if(nums[mid] > target && nums[left] <= target ){
                    right = mid - 1;
                }else{//后半部分找
                    left = mid + 1;
                }
            }else{//后部分有序
                //前半部分找
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{//后半部分找
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public boolean search01(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }
}
