package algorithm.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 * @title: FindShortestSubArray  697. 数组的度 (字段计数，数组)
 * @projectName studyDemo
 * @description: 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 * <p>
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * @date 2021/2/20
 */
public class FindShortestSubArray {

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    public static int findShortestSubArray(int[] nums) {
        //先求出数组的度  即出现频率最高的数
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;  //多出现一次，数组的第一个记录+1
                map.get(nums[i])[2] = i;//替换最后一次出现的的位置
            } else {
                map.put(nums[i], new int[]{1, i, i});   //int[]记录：出现次数，首次出现，最后出现
            }
        }

        //求出相同度最短子数组 （会出现相同的度）
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {  //求出现频次最高的数
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;//最短子数组
            } else if (maxNum == arr[0]) {  //度数相等的情况，取最小的
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }
}
