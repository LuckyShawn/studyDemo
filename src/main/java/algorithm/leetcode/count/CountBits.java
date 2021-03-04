package algorithm.leetcode.count;

import java.util.Arrays;

/**
 * @author Shawn
 * @title: CountBits 338. 比特位计数 (位运算)
 * @projectName studyDemo
 * @description: 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 通过次数86,958提交次数111,367
 *
 * 来源：力扣（LeetCode）
 * @date 2021/3/3
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println(3 & 2);
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits01(2)));
    }

    /**
     * 	1 ms 99.95%
     * 	42.7 MB 24.21%
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int ones = 0;
            int temp = i;
            while(temp>0){
                temp &= (temp - 1); //将 x 的二进制表示的最后一个 1 变成 0
                ones++;
            }
            bits[i] = ones;
        }
        return bits;
    }

    /**
     * 2 ms     60.00%
     * 42.8 MB  14.64%
     * @param num
     * @return
     */
    public static int[] countBits01(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public static int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

}


/**
 * 最直观的方法是对从 00 到 num 的每个数直接计算「一比特数」。
 *
 * 每个 int 型的数都可以用 32 位二进制数表示，只要遍历其二进制表示的每一位即可得到 1 的数目。
 *
 * 利用位运算的技巧，可以在一定程度上提升计算速度。按位与运算（&）的一个性质是：对于任意整数 x，令 x=x&(x−1)，
 * 该运算将 x 的二进制表示的最后一个 1 变成 0。因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
 *
 * 另外，部分编程语言有相应的内置函数，例如 Java 的 Integer.bitCount，
 * 读者可以自行尝试。需要注意的是，使用编程语言的内置函数时，不适用本方法的时间复杂度分析。
 *
 * 来源：LeetCode
 */
