package algorithm.leetcode.leetCodeTop.easy;

import java.util.*;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/24 0024
 */
public class IsValid {
    /**
     * 栈的使用，先进后出
     * 栈存左括号，匹配右括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 != 0){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();    //记住！！创建栈的方式，用双向链表
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};//括号的匹配map
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){ //如果map中存在，则peek一个，看是否能匹配，不匹配，返回false
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();    //匹配成功，弹出一个
            }else{
                stack.push(c);  //左括号，先放入栈中
            }
        }
        return stack.isEmpty();

    }
}
