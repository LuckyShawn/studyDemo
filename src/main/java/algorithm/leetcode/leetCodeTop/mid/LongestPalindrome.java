package algorithm.leetcode.leetCodeTop.mid;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/28 0028
 */
public class LongestPalindrome {
    /**
     * 中心扩散法--遍历所有下标，以下标为中心，利用回文串中心对称的特点，向两边扩散，记录能扩散到最大的值
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {    //如果是1个字符，肯定是回文串
            return s;
        }
        int maxLen = 0; //记录最大长度
        // 数组第一位记录起始位置，第二位记录长度
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            int[] odd = centerSpread(s, i, i);//奇数扩散
            int[] even = centerSpread(s, i, i + 1);//偶数扩散
            int[] max = odd[1] > even[1]? odd : even;   //右侧扩散谁大就取谁
            if(max[1] > maxLen){    //如果右侧比最大值大，则替换最大值maxLen
                res = max;
                maxLen = max[1];
            }
        }
        return s.substring(res[0],res[0] + res[1]);

    }

    /**
     * 中心扩散
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int[] centerSpread(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right - left - 1};
    }
}
