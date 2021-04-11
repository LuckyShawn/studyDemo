package algorithm.leetcode.arrays;

/**
 * @author Shawn 832. 翻转图像 （先逆序，后反转）（神奇的异或运算）
 * @title: FlipAndInvertImage
 * @projectName studyDemo
 * @description: 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1：
 *
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 *
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *  
 *
 * 提示：
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * @date 2021/2/24
 */
public class FlipAndInvertImage {
    public static void main(String[] args) {
        flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    }

    /**
     * 左右指针指向的数组值相等，异或1，不等则保留，左右指针值相等指的是中间数，异或1 (翻转和反转一步到位)
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {    //中间数
                A[i][left] ^= 1;
            }
        }
        return A;
    }

}
