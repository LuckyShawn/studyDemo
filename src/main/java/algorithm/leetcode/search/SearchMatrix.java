package algorithm.leetcode.search;

/**
 * @author Shawn
 * @title: SearchMatrix 74. 搜索二维矩阵  （二分查找）二维数组中：row = idx/n  ,col = idx % n;
 * @projectName studyDemo
 * @description: 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * 通过次数83,869提交次数206,655
 *
 * 来源：力扣（LeetCode）
 * @date 2021/3/3
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println( searchMatrix(matrix,3));
    }

    /**
     * 二分查找
     * 	0 ms    100.00%
     * 	37.8 MB 85.29%
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int midIndex, midElement;
        while (left <= right) {
            midIndex = left + ((right - left) >> 1);    //中间值的索引
            midElement = matrix[midIndex / n][midIndex % n];//中间值  二维数组中：row = idx/n  ,col = idx % n;
            if (target == midElement){
                return true;
            }else{
                if (target < midElement){
                    right = midIndex - 1;
                }else {
                    left = midIndex + 1;
                }
            }
        }
        return false;
    }
/**
 * 由于该 虚 数组的序号可以由下式方便地转化为原矩阵中的行和列 (我们当然不会真的创建一个新数组) ，该有序数组非常适合二分查找。
 *
 * row = idx / n ， col = idx % n。
 *
 * 算法
 *
 * 这是一个标准二分查找算法 :
 *
 * 初始化左右序号
 * left = 0 和 right = m x n - 1。
 *
 * While left < right :
 *
 * 选取虚数组最中间的序号作为中间序号: midIdx = (left + right) / 2。
 *
 * 该序号对应于原矩阵中的 row = midIdx // n行 col = midIdx % n 列, 由此可以拿到中间元素 midElement。该元素将虚数组分为两部分。
 *
 * 比较 midElement 与 target 以确定在哪一部分进行进一步查找。
 */


    /**
     * 暴力法
     * 0 ms	    100.00%
     * 38.1 MB  24.82%
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix02(int[][] matrix, int target) {
        int x = matrix.length,y = matrix[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
