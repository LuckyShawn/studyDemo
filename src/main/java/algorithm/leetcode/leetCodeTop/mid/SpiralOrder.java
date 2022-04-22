package algorithm.leetcode.leetCodeTop.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: SpiralOrder 54. 螺旋矩阵  （mid）（模拟）
 * @projectName studyDemo
 * @description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [
 * [1,2,3,4],
 * [5,6,7,8],
 * [9,10,11,12]
 * ]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 通过次数114,203提交次数259,241
 * @date 2022/4/15
 */
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        List<Integer> ans = new ArrayList<>(m * n);
        while(right >= left && bottom >= top){

            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }

            for (int i = top; i < bottom; i++) {
                ans.add(matrix[top][i]);
            }

            for (int i = bottom; i > top; i--) {
                ans.add(matrix[bottom][i]);
            }


        }

        return ans;

    }
}
