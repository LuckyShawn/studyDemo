package algorithm.leetcode.leetCodeTop.mid;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: GetMaxLen 1567. 乘积为正数的最长子数组长度
 * @projectName studyDemo
 * @description: 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度。
 * <p>
 *  
 * <p>
 * 示例  1：
 * <p>
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * @date 2022/2/17
 */
public class GetMaxLen {

    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{0,1,-2,-3,-4}));
        System.out.println(getMaxLen1(new int[]{0,1,-2,-3,-4}));
        System.out.println(getMaxLen2(new int[]{0,1,-2,-3,-4}));
    }

    /**
     * 贪心 双指针
     * @param nums
     * @return
     */
    public static int getMaxLen(int[] nums) {
        int n = nums.length;
        // 负、正数个数 第一个负数出现的位置
        int neg = 0, pos = 0, fisrt = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // 遇到0所有标记初始化
                pos = 0;
                neg = 0;
                fisrt = -1;
            } else if (nums[i] > 0) {
                pos++;
            } else {
                // 记录该段第一个负数出现的位置
                if (fisrt == -1) {
                    fisrt = i;
                }
                neg++;
            }
            if (neg % 2 == 0) {
                // 该段所有数乘积为正
                ans = Math.max(ans, pos + neg);
            } else {
                // 从第一个负数出现的位置后面到当前位置的乘积为正
                ans = Math.max(ans, i - fisrt);
            }
        }
        return ans;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int getMaxLen1(int[] nums) {
        int length = nums.length;
        int[] positive = new int[length];
        int[] negative = new int[length];
        //初始化
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLength = positive[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {//边界
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;//转移方程
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLength = Math.max(maxLength, positive[i]);
        }
        return maxLength;
    }

    /**
     * 动态规划，滚动数
     * @param nums
     * @return
     */
    public static int getMaxLen2(int[] nums) {
        int pos = 0;
        int neg = 0;
        if(nums[0] > 0){
            pos++;
        }else if(nums[0] < 0){
            neg++;
        }
        int maxLength = pos;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0){
                pos++;
                neg = neg > 0 ? neg + 1 : 0;
            }else if(nums[i] < 0){
                int negNew = pos + 1;
                int posNew = neg > 0 ? neg + 1 : 0;
                pos = posNew;
                neg = negNew;
            }else{
                pos = 0;
                neg = 0;
            }
            maxLength = Math.max(pos,maxLength);
        }
        return maxLength;


    }

}

