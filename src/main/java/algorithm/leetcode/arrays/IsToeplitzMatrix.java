package algorithm.leetcode.arrays;

/**
 * @author Shawn
 * @title: IsToeplitzMatrix  766. 托普利茨矩阵
 * @projectName studyDemo
 * @description: 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 输入：matrix =
 * [[1,2,3,4],
 * [5,1,2,3],
 * [9,5,1,2]]
 *
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 * 输入：matrix =
 * [[1,2],
 * [2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 *
 * 进阶：
 * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 *
 * @date 2021/2/22
 */
public class IsToeplitzMatrix {

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println(isToeplitzMatrix01(new int[][]{{1,2,3,4},{4,1,2,3},{9,5,1,2}}));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i+1 < matrix.length && j+1 < matrix[i].length && matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isToeplitzMatrix01(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
/*
[1,2,3,4]
[5,1,2,3]
[9,5,1,2]
*/
