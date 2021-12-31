package algorithm.leetcode.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: IsPossibleDivide 1296. 划分数组为连续数字的集合
 * @projectName studyDemo
 * @description: 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 true；否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 * 示例 3：
 *
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 * 示例 4：
 *
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 *  
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *  
 *
 * 注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/
 *
 * 通过次数9,433提交次数19,716
 * @date 2021/12/31
 */


public class IsPossibleDivide {

    public static void main(String[] args) {
        System.out.println(isPossibleDivide(new int[]{1,2,3,3,4,4,5,6},4));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0){
            return false;
        }
        Arrays.sort(nums);
        Map<Integer,Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : nums){
            cnt.put(x,cnt.getOrDefault(x,0)+1);
        }
        for (int x : nums){
            if(!cnt.containsKey(x)){
                continue;
            }
            for (int j = 0; j < k; j++) {
                int temp = x + j;
                if(!cnt.containsKey(temp)){
                    return false;
                }
                cnt.put(temp,cnt.get(temp)-1);
                if(cnt.get(temp)==0){
                    cnt.remove(temp);
                }
            }
        }
        return true;
    }
}
