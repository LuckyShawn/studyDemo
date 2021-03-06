package algorithm.leetcode.notType;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: HammingWeight 191. 位1的个数
 * @projectName studyDemo
 * @description: 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 *  
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *  
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 *
 * 提示：
 *
 * 输入必须是长度为 32 的 二进制串 。
 *  
 *
 * 进阶：
 *
 * 如果多次调用这个函数，你将如何优化你的算法？
 * 通过次数117,086提交次数162,358
 *
 *
 * @date 2021/3/22
 */
public class HammingWeight {
    // you need to treat n as an unsigned value

    /**
     * 我们可以直接循环检查给定整数 n 的二进制位的每一位是否为 1。
     *
     * 具体代码中，当检查第 i 位时，我们可以让 n与 2^i进行与运算，当且仅当 n 的第 i 位为 1 时，运算结果不为 0。
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {  //1 << i  2的i次方
                ret++;
            }
        }
        return ret;

    }
}
