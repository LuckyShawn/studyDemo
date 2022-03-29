package algorithm.leetcode.hard;

import java.util.Random;

/**
 * @Description 912. 排序数组 使用快排
 * @Authod shawn
 * @create 2022/3/20 0020
 */
public class QuickSort {

    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    Random rand = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int index = partition(nums, left, right);   //返回的中间值
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }



    public int partition(int[] nums, int left, int right) {
        //随机选择一个数作为元组
        int randomIndex = rand.nextInt(right - left + 1) + left;   //概率事件，平均了好情况和差情况的概率
        //交换到右边
        swap(nums, randomIndex, left);

        int index = left;
        int pivot = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {    //此处一定要理解，i和index，类似于两个指针，i在不停的移动，index跟着动，没多一个数就移动一位
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, left, index);  //index最后到了pivot的左一个
        return index;
    }

    /**
     * 交换
     * @param nums
     * @param index01
     * @param index02
     */
    public void swap(int[] nums, int index01, int index02) {
        int temp = nums[index01];
        nums[index01] = nums[index02];
        nums[index02] = temp;
    }


    /**
     * 对数组 nums 的子区间 [left, right] 使用插入排序
     *
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int index = i;
            int temp = nums[i];
            while (index >  left && nums[index - 1] > temp ){
                nums[index] = nums[index - 1];  //当前数小于前一个数，则把前一个数后移一位
                index --;
            }
            nums[index] = temp; //在适当的位置插入
        }
    }
}
