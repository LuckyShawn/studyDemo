package algorithm.leetcode.search;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 * 通过次数106,168提交次数202,655
 * <p>
 * 来源：力扣（LeetCode）
 */
public class SearchRotateMin {
    public static void main(String[] args) {
        System.out.println(findMin01(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //单调递增直接返回最左的
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + ((right - left) >> 1);
            //left 和 mid之间递增，那么最小值肯定在mid右边
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else if (nums[left] > nums[mid]) {//最小值在mid左边
                right = mid;
            }
        }
        return -1;
    }

    /**
     * 只要出现递减，右边一个必是最小值
     *
     * @param nums
     * @return
     */
    public static int findMin01(int[] nums) {
        if (nums.length == 1) return nums[0];//只有一个数
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] <= nums[right]) return nums[left];//单调递增
        while (left + 1 < right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > nums[middle + 1]) {
                return nums[middle + 1];    //mid大于右边，右侧一个必为最小值
            }
            if (nums[middle] < nums[middle - 1]) {
                return nums[middle];//mid小于左边，mid必为最小值
            }
            if (nums[middle] > nums[0]) {//mid大于left
                left = middle;
            } else {
                right = middle;
            }
        }
        return nums[right];
    }
}
