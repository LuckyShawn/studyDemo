package algorithm.leetcode.arrays;

/**
 * @author Shawn
 * @title: MaxSatisfied  1052. 爱生气的书店老板 （滑动窗口）
 * @projectName studyDemo
 * @description: 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 * @date 2021/2/23
 */
public class MaxSatisfied {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        System.out.println(test(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    /**
     * 解法1 好理解（滑动窗口） 耗时较长
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ret = 0, extra = 0, tmp = 0;
        int left = 0, right = 0;
        while (right < customers.length) {
            ret += (1 - grumpy[right]) * customers[right];//确定满意的顾客
            //滑动窗口(像虫虫一样，右边向前挪动，后面跟上)
            tmp += grumpy[right] * customers[right++];
            extra = Math.max(extra, tmp);
            if (right - left == X) tmp -= grumpy[left] * customers[left++];
        }
        return ret + extra;
    }

    /**
     * 耗时较短
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public static int maxSatisfied01(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {//总满意顾客数
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }

    public static int test(int[] customers, int[] grumpy, int X) {
        int left = 0;
        int right = 0;
        int res = 0, extra = 0, temp = 0;
        while (right < customers.length) {
            res += customers[right] * (1 - grumpy[right]);
            temp += customers[right] * grumpy[right++];
            extra = Math.max(temp, extra);
            if (right - left == X) {
                temp -= grumpy[left] * customers[left++];
            }
        }

        return extra + res;

    }
}
