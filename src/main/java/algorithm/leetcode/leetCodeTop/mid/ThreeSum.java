package algorithm.leetcode.leetCodeTop.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shawn   * 来源：力扣（LeetCode）
 * @title: ThreeSum 15. 三数之和
 * @projectName studyDemo
 * @description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 通过次数796,958提交次数2,310,554
 *
 * @date 2022/2/15
 */
public class ThreeSum {

    public static void main(String[] args) {

        threeSum(new int[]{-1,0,1,2,-1,-4});

    }

    /**
     * 注意临界值3，注意左右指针和固定值去重
     * 固定值循环，左右指针循环直到相遇
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        int n = nums.length;
        if(nums == null || n < 3){
            return ansList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0){//经过排序后，如果固定数大于0，则不可能三数和为0
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ansList.add(list);
                    //重复问题
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum > 0){//相加加过大于0，说明数需要减少
                    right--;
                }else if(sum < 0){
                    left++;
                }
            }
        }
        return ansList;
    }
}
