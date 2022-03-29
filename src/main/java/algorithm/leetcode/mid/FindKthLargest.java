package algorithm.leetcode.mid;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description 215. 数组中的第K个最大元素 mid
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * @Authod shawn
 * @create 2022/3/19 0019
 */
public class FindKthLargest {

    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{5,6,7,3,1,2,9,12,10},2));
    }



    public static int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int target = length - k;    //排序后的倒数第k个就是第k大的值

        //定义左右指针
        int left = 0;
        int right = length - 1;

        while(true){
            int index = partition(nums,left,right);
            if(index == target){
                return nums[index];
            }else if(index < target){
                left = index +1;
            }else{
                right = index - 1;
            }
        }

    }

    public static int partition(int[] nums,int left,int right){
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }
        int p = nums[left];
        int index = left;//从left开始

        /**
         * .[5, 6, 7, 3, 1, 2, 9, 12, 10]
         * 大于povit不动，小于poivt的值index往前，和left交换，最后povit值再和index交换，那么5就放在了该放的地方
         * [2, 3, 1, 5, 6, 7, 9, 12, 10]
         */

        for (int i = left;i <= right; i++){
            if(nums[i] < p){
                index++;        //当小于p值时，指针移动一位，
                swap(nums,i,index);
                System.out.println(  Arrays.toString(nums));
            }
        }
        swap(nums,index,left);
        return index;
    }


    /**
     * 交换
     * @param nums
     * @param index1
     * @param index2
     */
    public static void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
