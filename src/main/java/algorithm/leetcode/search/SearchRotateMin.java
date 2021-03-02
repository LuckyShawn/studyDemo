package algorithm.leetcode.search;

/**
 * 153. 寻找旋转排序数组中的最小值 (二分查找)
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 * 通过次数106,168提交次数202,655
 *
 * 来源：力扣（LeetCode）
 */
public class SearchRotateMin {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{1}));
    }

    /**
     * 	0 ms  100.00%
     * 	37.8 MB  71.22%
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            //单调递增直接返回最左的
            if(nums[left] <= nums[right]){
                return nums[left];
            }
            int mid = left + ((right -left) >> 1);
            //left 和 mid之间递增，那么最小值肯定在mid右边
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else if(nums[left] > nums[mid]){//最小值在mid左边
                right = mid;
            }
        }
        return -1;
    }
}
