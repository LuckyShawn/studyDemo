package algorithm.leetcode.leetCodeTop.easy;


/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/27 0027
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right){   //双指针往中间靠，相遇则是回文串
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){  //isLetterOrDigit是字母或者数字
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
