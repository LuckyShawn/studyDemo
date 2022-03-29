package algorithm.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/17 0017
 */
public class StringTest {
    public static void main(String[] args) {
        String [] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Arrays.sort(words, (a, b) ->  {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        System.out.println(Arrays.toString(words));
        String longest = "";
        Set<String> candidates = new HashSet<String>();
        candidates.add("");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (candidates.contains(word.substring(0, word.length() - 1))) {
                candidates.add(word);
                longest = word;
            }
        }
    }
}
