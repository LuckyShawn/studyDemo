package algorithm.leetcode.notType;

/**
 * @author Shawn  * 来源：力扣（LeetCode）通过次数52,482提交次数141,680
 * @title: JudgeSquareSum 633. 平方数之和 （Mid）
 * @projectName studyDemo
 * @description: 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 *
 * @date 2021/4/28
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));

        System.out.println(judgeSquareSum01(5));
    }
    public static boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);//根号求b
            if (b == (int) b) {//开跟没有余数
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum01(int c){
        for(long a = 0;a * a <= c ; a++){
            double b = Math.sqrt(c - a * a);
            if(b == (int)b){
                return true;
            }
        }
        return false;
    }
}
