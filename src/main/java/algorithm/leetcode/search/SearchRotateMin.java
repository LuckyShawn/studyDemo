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
        System.out.println(findMin01(new int[]{3,4,5,1,2}));
        System.out.println(findMin01(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin01(new int[]{6,5,4,3,2,1,0}));
        System.out.println(findMin01(new int[]{6,5,4,3,2,1,0}));
        System.out.println(findMin01(new int[]{1}));
    }

    /**
     * 此方法是否有问题？
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
            //单调递减直接返回最右的
            if(nums[left] >= nums[right]){
                return nums[right];
            }
            int mid = left + ((right -left) >> 1);
            //left 和 mid之间递增，那么最小值肯定在mid右边
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else if(nums[left] > nums[mid]){
                right = mid;
            }
        }
        return -1;
    }

    /**
     * 官解，推荐方法，易于理解
     * @param nums
     * @return
     */
    public static int findMin01(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right -left) >> 1);
            //中值小于右边值，说明最小值在mid左侧，排除右边，在左侧进行查找
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {//中值大于等于右边，最小值在mid右侧，排除左边，在右侧查找
                left = mid + 1;
            }
        }
        return nums[left];
    }



}
