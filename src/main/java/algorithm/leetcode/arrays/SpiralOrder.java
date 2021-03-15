package algorithm.leetcode.arrays;

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
 *
 * @date 2021/3/15
 */
public class SpiralOrder {
    public static void main(String[] args) {
       int[][] matrix =  new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder01(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            //下一个数据
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            //超出边界或被访问过，改变方向
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    /**
     * 按层模拟
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了54.18%的用户
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder01(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0,right = cols - 1,top = 0,bottom = rows - 1;
        while(left <= right && top <= bottom){
            for (int col  = left; col <= right; col++) {
                order.add(matrix[top][col]);
            }

            for (int row = top + 1;row <= bottom; row++){
                order.add(matrix[row][right]);
            }

            if(left < right && top < bottom){
                for (int col = right - 1;col > left ; col-- ){
                    order.add(matrix[bottom][col]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            right--;
            top++;
            bottom--;
            left++;

        }
        return order;
    }
}
