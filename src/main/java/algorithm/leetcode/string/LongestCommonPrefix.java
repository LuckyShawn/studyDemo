package algorithm.leetcode.string;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 通过次数456,474提交次数1,163,334
 *
 * 来源：力扣（LeetCode）
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix01(new String[]{"flower","flow","flight"}));

        String str = "abcde";
        System.out.println(str.charAt(0));
        System.out.println(str.valueOf(2));
        System.out.println(str.toCharArray());
    }

    /**
     * 1 ms	    84.01%
     * 36.5 MB  58.90%
     * 纵向扫描
     * 方法一是横向扫描，依次遍历每个字符串，更新最长公共前缀。另一种方法是纵向扫描。纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，
     * 如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix01(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int arrLen = strs.length;
        int strLen = strs[0].length();  //其实可以随便取一条当做对照
        for (int i = 0; i < strLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < arrLen; j++) {
                if(strs[j].length() == i || strs[j].charAt(i) != c){    //当往后遍历的字符串达到最大值或者后续字符没有匹配上，则返回结果
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 1 ms	    84.01%
     * 36.8 MB  21.45%
     *
     * 横向扫描
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        //Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    /**
     * 字符串两两对比
     * @param str1
     * @param str2
     * @return
     */
    public static String longestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }
}
