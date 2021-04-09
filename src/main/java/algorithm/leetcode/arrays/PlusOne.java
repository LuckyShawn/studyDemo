package algorithm.leetcode.arrays;

import java.util.Arrays;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: PlusOne 66. 加一(easy) （注意进位问题）
 * @projectName studyDemo
 * @description: 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * 通过次数273,747提交次数599,295
 *
 * @date 2021/4/9
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3,5})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
    }

    /**
     * 注意进位
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了69.38%的用户
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            //不进位，直接返回，进位继续往前+1，再进位，再+1
            if (digits[i] != 0) {
                return digits;
            }
        }
        //如果进位超过了数组，比如[9,9,9] -->[1,0,0,0],需要扩容数组
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne01(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
