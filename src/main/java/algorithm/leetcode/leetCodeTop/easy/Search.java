package algorithm.leetcode.leetCodeTop.easy;

/**
 * @author Shawn
 * @title: Search
 * @projectName studyDemo
 * @description: TODO
 * @date 2022/4/18
 */
public class Search {
    /**
     * TOP
     * 1、左右指针，结束条件左指针<=右指针
     * 2、中值left + ((right - left) >> 1);
     * 3、target == nums[mid]直接返回下标，nums[mid] > target，说明在左侧，right = mid -1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) { //说明在左侧，right = mid - 1
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

}
