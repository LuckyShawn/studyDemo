package algorithm.leetcode.leetCodeTop.easy;

import java.util.Arrays;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/23 0023
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new Merge().merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并有序数组，逆序遍历
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right1 = m - 1;
        int right2 = n - 1;
        int size = m + n - 1;
        while (right1 >= 0 && right2 >= 0){
            if(nums1[right1] <= nums2[right2]){
                nums1[size--] = nums2[right2--];
            }else{
                nums1[size--] = nums1[right1--];
            }
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, right2 + 1);
    }
}
