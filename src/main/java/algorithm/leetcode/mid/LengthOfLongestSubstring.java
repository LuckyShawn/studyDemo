package algorithm.leetcode.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @Description 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 * @Authod shawn
 * @create 2022/3/15 0015
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(map.get(c),start);
            }
            map.put(c,end + 1);//存+1是因为至少有一个数不重复
            ans = Math.max(end - start + 1 ,ans);
        }

        return ans;

    }
}
