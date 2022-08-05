package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author Shawn
 * @title: InsertSort
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/10/26
 */
public class InsertSort {

    public static void main(String[] args) throws Exception {
        //System.out.println(Arrays.toString(sort(new int[]{5,6,4,10,2,1 })));
        System.out.println(Arrays.toString(is(new int[]{5,6,4,10,2,1 })));
    }

    public static int[] sort(int[] sourceArray) throws Exception {
        int[] copyArray = Arrays.copyOf(sourceArray,sourceArray.length);

        for (int i = 1; i < copyArray.length; i++) {
            int temp = copyArray[i];
            int j = i;
            while (j > 0 && temp < copyArray[j - 1]){
                copyArray[j] = copyArray[j - 1];
                j--;
            }
            if(j != i){
                copyArray[j] = temp;
            }

        }
        return copyArray;
    }

    public static int[] is (int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while(j > 0 && temp < nums[j - 1]){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
