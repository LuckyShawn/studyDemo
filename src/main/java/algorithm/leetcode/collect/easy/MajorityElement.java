package algorithm.leetcode.collect.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: MajorityElement  169. 多数元素
 * @projectName studyDemo
 * @description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 通过次数268,307提交次数408,445
 *
 *
 * @date 2021/2/26
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement01(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement01(new int[]{3,2,3}));
    }

    /**
     * 哈希记录出现次数，选出哈希值最大的key即为答案
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 16 ms 20.91%
     * 43.5 MB 27.85%
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
       Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],(map.get(nums[i]))+1);
            }

        }
        int ans = 0;
        int maxNum= 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxNum = Math.max(entry.getValue(),maxNum);
            if(maxNum == entry.getValue()){
                ans = entry.getKey();
            }
        }
       return ans;
    }

    /**
     * 根据答案多数元素为多于n/2的数
     * 排序后，选择中间位置的众数即为答案
     * 2 ms	70.57%
     * 41.6 MB 75.58%
     * @param nums
     * @return
     */
    public static int majorityElement01(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
