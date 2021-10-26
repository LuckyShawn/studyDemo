package algorithm.leetcode.easy;

import java.util.*;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: NextGreaterElement  496. 下一个更大元素 I
 * @projectName studyDemo
 * @description: 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * 通过次数110,124提交次数159,292
 * @date 2021/10/26
 */


public class NextGreaterElement {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement01(new int[]{4,1,2},new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement02(new int[]{4,1,2},new int[]{1,3,4,2})));
    }

    /**
     * 暴力法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int[] res = new int[a];
        for (int i = 0; i < a; i++) {
            int j = 0;
            while(j < b && nums2[j] != nums1[i]){   //
                j++;
            }
            int k = j + 1;
            while(k < b && nums2[k] < nums2[j] ){
                k++;
            }
            res[i] = k < b ? nums2[k] : -1;

        }
        return res;

    }

    /**
     * 我们可以先预处理nums2 ，使查询nums1中的每个元素在nums2中对应位置的右边的第一个更大的元素值时不需要再遍历 nums2。于是，我们将题目分解为两个子问题：
     *
     * 第1个子问题：如何更高效地计算nums2中每个元素右边的第一个更大的值；
     * 第2个子问题：如何存储第1个子问题的结果。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement01 (int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    /**
     * 单调栈 + map
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement02 (int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1 ; i >=0 ; i--) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()){ //栈不为空，且nums2中最后的数大于栈中的最上面的数，则弹出
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty() ? -1 : stack.peek());//用map存nums2每个数字对应后面一个大的数
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return  res;
    }

}
