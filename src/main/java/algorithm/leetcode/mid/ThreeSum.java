package algorithm.leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: ThreeSum 15. 三数之和
 * @projectName studyDemo
 * @description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 通过次数586,786提交次数1,782,522
 * @date 2021/8/3
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum01(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + target == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;
                    right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] + target < 0) {
                    left++;
                } else {  // nums[left] + nums[right] + target > 0
                    right--;
                }
            }
        }
        return ans;
    }


    public static List<List<Integer>> threeSum01(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3){ //注意边界问题
            return ans;
        }
        int length = nums.length;
        Arrays.sort(nums);//O(nlogn)
        for (int i = 0; i < length; i++) {
            if(nums[i] > 0){    //如果排序后的第一位大于0，则后面不可能三数和为0,结束
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){   //去重
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                List temp = new ArrayList();
                if(sum == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);

                    //去重，做指针和下一个相等（题目规定不能重复）
                    while (left < right && nums[left] == nums[left + 1]){
                        left++ ;
                    }//去重，右指针和前一个相等
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }

        }
        return ans;
    }
}
