package algorithm.leetcode.string;

/**
 * @author Shawn  来源：力扣（LeetCode）
 * @title: IsPalindrome 9. 回文数
 * @projectName studyDemo
 * @description: 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *  
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * @date 2021/2/25
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome01(121));
        System.out.println(isPalindrome01(-121));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(222));
        System.out.println(isPalindrome(221));
    }

    /**
     * 简单解法
     * @param x
     * @return
     */
    public static boolean isPalindrome01(int x) {
        String reverseString = (new StringBuffer(x + "")).reverse().toString();
        return (x+ "").equals(reverseString);
    }

    /**
     * 是否有问题呢？虽然代码通过了
     * 通过	10 ms 76.78%	37.9 MB 61.15%
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if(s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 数学解法
     * @param x  -231 <= x <= 231 - 1
     * @return
     */
    public static boolean isPalinfrome02(int x){
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
