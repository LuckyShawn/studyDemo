package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: ReadBinaryWatch 401. 二进制手表 (回溯)
 * @projectName studyDemo
 * @description: 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * <p>
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * 例如，上面的二进制手表读取 “3:25”。
 * <p>
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *  
 * <p>
 * 提示：
 * <p>
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 * 通过次数24,296提交次数45,467
 * @date 2021/3/5
 */
public class ReadBinaryWatch {

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }


    List<Integer> mins;
    List<String> res;
    public List<String> readBinaryWatch01(int num) {
        res = new ArrayList<>();
        mins = new ArrayList<>();

        for (int i = 0; i < 6 && num >= i; i++) {
            dfs(0, 0, i, true);
            dfs(0, 0, num - i, false);
            mins.clear();
        }

        return res;
    }

    private void dfs(int st, int sum, int cnt, boolean flag) {
        if (cnt == 0) {
            if (flag) {
                mins.add(sum);
            } else {
                if (!mins.isEmpty()) {
                    for (int m : mins) {
                        // res.add(String.format("%d:%02d", sum, m));
                        StringBuilder sb = new StringBuilder();
                        sb.append(sum).append(':');
                        if (m < 10) {
                            sb.append('0');
                        }
                        sb.append(m);
                        res.add(sb.toString());
                    }
                }
            }
            return;
        }

        for (int i = st; i < (flag ? 6 : 4); i++) {
            int temp = (int)Math.pow(2, i);
            if (flag && sum + temp >= 60 || !flag && sum + temp >= 12) {
                break;
            }
            dfs(i + 1, sum + temp, cnt - 1, flag);
        }
    }


    /**
     * 模拟暴力法
     * 执行用时：1 ms, 在所有 Java 提交中击败了87.55%的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了91.24%的用户
     * @param num
     * @return
     */
    public static List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int count = Integer.bitCount(i) + Integer.bitCount(j);  //亮灯的数量即为1的数量
                if (num == count) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(":");
                    if (j < 10) {
                        sb.append("0");
                    }
                    sb.append(j);
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }

    /**
     *
     * @return
     */
    public int countOne(int num){
        int one = 0;
        while(num > 0){
            if((num & 1) == 1){
                one++;
               num >>= 1;
            }
        }
        return one;
    }

}
