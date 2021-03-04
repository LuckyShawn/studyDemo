package algorithm.leetcode.collect.easy;

import java.util.Arrays;

/**
 * @author Shawn
 * @title: MergeArray 88. 合并两个有序数组
 * @projectName studyDemo
 * @description: 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * 通过次数275,891提交次数557,958
 *
 * 来源：力扣（LeetCode）
 * @date 2021/3/3
 */
public class MergeArray {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        merge01(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }

    /**
     * 1 ms     23.13%
     * 38.6 MB  43.59%
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 	1 ms        23.13%
     * 	38.3 MB     94.44%
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge01(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge02(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

}
