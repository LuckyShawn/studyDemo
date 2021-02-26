package algorithm.leetcode.easy.begin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: SingleNumber 136. 只出现一次的数字
 * @projectName studyDemo
 * @description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 通过次数339,668提交次数478,889
 *
 * @date 2021/2/26
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,1,2,2,3}));
        System.out.println(singleNumber01(new int[]{1,1,2,2,3}));
        System.out.println(singleNumber01(new int[]{4,1,2,2,3,4,3}));
        System.out.println(singleNumber02(new int[]{4,1,2,2,3,4,3}));
    }

    /**
     * 	377 ms	5.00%
     * 	38.8 MB 26.96%
     * 双重循环暴力破解
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if(!flag){
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 遍历一遍
     * 13 ms 19.65%
     * 38.8 MB 37.83%
     * @param nums
     * @return
     */
    public static int singleNumber01(int[] nums){
        Set set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        return (int)set.iterator().next();
    }

    /**
     *  1 ms 99.99%
     *  38.7 MB 53.36%
     *  异或
     * 任何数和 0 做异或运算，结果仍然是原来的数
     * 任何数和其自身做异或运算，结果是 0  （√）
     * 异或运算满足交换律和结合律
     * @param nums
     * @return
     */
    public static int singleNumber02(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
