package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: CheckPerfectNumber 507. 完美数
 * @projectName studyDemo
 * @description: 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 *
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 *
 * 输入：num = 6
 * 输出：true
 * 示例 3：
 *
 * 输入：num = 496
 * 输出：true
 * 示例 4：
 *
 * 输入：num = 8128
 * 输出：true
 * 示例 5：
 *
 * 输入：num = 2
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= num <= 108
 * 通过次数53,692提交次数112,672
 * @date 2021/12/31
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(33550336));
        System.out.println(e(28));
    }

    /**
     * 勇士2000ms
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber(int num) {
        if(num<=2){
            return false;
        }
        int ans = 1;
        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                ans+=i;
            }
        }
        return ans == num;
    }

    /**
     * 用是2ms
     * @param num
     * @return
     */
    public static boolean e(int num){
        if (num == 1) {
            return false;
        }

        int sum = 1;
        for (int d = 2; d * d <= num; ++d) {
            if (num % d == 0) {
                sum += d;
                if (d * d < num) {
                    sum += num / d;
                }
            }
        }
        return sum == num;
    }
}
