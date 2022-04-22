package algorithm.leetcode.leetCodeTop.mid;

import java.util.Arrays;

/**
 * @author Shawn
 * @title: MergeSort 合并排序
 * @projectName studyDemo
 * @description: TODO
 * @date 2022/3/23
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeSort().sortArray(new int[]{5,6,8,7,9,3,1,1,5,2,20})));
    }

    // 归并排序

    /**
     * 列表大小等于或小于该大小，将优先于 mergeSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    /**
     * 对数组 nums 的子区间 [left, right] 进行归并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp  用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
     */
    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int mid = left + (right - left) >> 1;
        // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
        // int mid = (left + right) >>> 1;

        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        // 如果数组的这个子区间本身有序，无需合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    /**
     * 对数组 arr 的子区间 [left, right] 使用插入排序
     *
     * @param arr   给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i;
            while (j > left && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    /**
     * 合并两个有序数组：先把值复制到临时数组，再合并回去
     *
     * @param nums
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     * @param temp  全局使用的临时数组
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right + 1 - left);

        int i = left;
        int j = mid + 1;

        int k = 0;  //临时数组初始指针

        while(i <= mid && j <=  right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= right){
            temp[k++] = nums[j++];
        }
        k = 0;
        while(left <= right){
            nums[left++] = temp[k++];
        }


    }

}
