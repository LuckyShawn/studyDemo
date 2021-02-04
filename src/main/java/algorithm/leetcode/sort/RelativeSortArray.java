package algorithm.leetcode.sort;

import java.util.Arrays;

/**
 * @author Shawn
 * @title: RelativeSortArray (计数排序)
 * @projectName studyDemo
 * @description: 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中

 * @date 2021/2/2
 */



public class RelativeSortArray {



    public static void main(String[] args) {
//        [2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31]
//        [2,42,38,0,43,21]
        //预期：[2,42,38,0,43,21,5,7,12,12,13,23,24,24,27,29,30,31,33,48]
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31},new int[]{2,42,38,0,43,21})));
        //System.out.println(Arrays.toString(a(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31},new int[]{2,42,38,0,43,21})));
    }

    public static int[] relativeSortArray(int[] arr1,int[] arr2){
        int[] temp = new int[1001];
        for(int a : arr1){
            temp[a]++;
        }
        int index = 0;
        for(int b : arr2){
            while(temp[b] > 0){
                arr1[index++] = b;
                temp[b]--;
            }
        }

        for(int i=0 ;i < temp.length ; i++){
            while(temp[i] > 0){
                arr1[index++] =  i;
                temp[i]--;
            }
        }
        return arr1;
    }



}
