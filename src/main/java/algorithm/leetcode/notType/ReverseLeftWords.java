package algorithm.leetcode.notType;

/**
 * @author Shawn
 * @title: ReverseLeftWords 剑指 58 - II. 左旋转字符串(字符串切片 API substring)
 * @projectName studyDemo
 * @description: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * 限制：
 * 1 <= k < s.length <= 10000
 *
 * @date 2021/2/20
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcd",2));
        System.out.println(reverseLeftWords2("abcd",2));
    }

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);//切片后面的拼接到前面，前面拼接到后面
    }
    public static String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++){
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}
