package algorithm.leetcode.arrays;

import java.util.Arrays;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: GenerateMatrix 59. 螺旋矩阵 II (中等)
 * @projectName studyDemo
 * @description: 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 通过次数65,396提交次数83,347
 *
 * @date 2021/3/15 0015下午 11:05
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int [][] matrix = generateMatrix(3);
        System.out.println(Arrays.toString(generateMatrix(3)));
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了50.52%的用户
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
            int length = n * n;
            int left = 0,right = n-1,top = 0,bottom = n-1;  //边界
            int[][] resMatrix = new int[n][n];
            int num = 1;//从1开始
            while(num <= length){
                //行不动，列右移，当列达到有边界停止移动，上边界下移一位
                for (int col = left; col <= right; col++) {
                    resMatrix[top][col] = num++;
                }
                top++;
                //列不动，行下移，当行达到下边界停止移动，右边界左移一位
                for (int row = top; row <= bottom; row++) {
                    resMatrix[row][right] = num++;
                }
                right--;
                //行不懂，列左移，当行达到左边界停止移动，下边界上移一位
                for (int col = right; col >= left; col--) {
                    resMatrix[bottom][col] = num++;
                }
                bottom--;
                //列不懂，行上移，当行达到上边界停止移动，左边界右移一位
                for (int row = bottom; row >= top; row--) {
                    resMatrix[row][left] = num++;
                }
                left++;
            }

            return resMatrix;
        }


}
