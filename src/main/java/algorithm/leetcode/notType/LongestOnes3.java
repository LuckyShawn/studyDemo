package algorithm.leetcode.notType;

/**
 * @author Shawn
 * @title: LongestOnes3  1004. 最大连续1的个数 III  (滑动窗口)
 * @projectName studyDemo
 * @description: 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1*,1,1,1,1,1*]
 * 粗体(带*)数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1*,1*,1,1,1,1*,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 */
public class LongestOnes3 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }

    public static int longestOnes(int[] A, int K) {
        int left = 0,right = 0,result = 0,zeros = 0;
        while(right < A.length){
            if(A[right] == 0){
                zeros ++;
            }
            while(zeros > K ){
                if(A[left++] == 0){
                    zeros --;
                }
            }
            result = Math.max(result,right - left + 1);
            right ++;
        }
        return result;
    }

}
