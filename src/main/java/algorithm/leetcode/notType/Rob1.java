package algorithm.leetcode.notType;

/**
 * @author Shawn  来源：力扣（LeetCode）
 * @title: Rob 198. 打家劫舍(mid)(动态规划)
 * @projectName studyDemo
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 通过次数276,523提交次数567,034
 *
 * @date 2021/4/15
 */
public class Rob1 {

    public static void main(String[] args) {
        System.out.println(rob2(new int[]{1,2,5,10,9,1}));
        System.out.println(rob2dp(new int[]{1,2,5,10,9,1}));
    }

    /**
     * 滚动数组，空间优化（只需要两个变量 O(n) --> O(1)）
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static int rob2dp(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length ==1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //两种情况，偷与不偷
            //偷：不能偷i-1了，偷i-2，dp[i-2]表示i-2之前的最高金额
            //不透：那么计算i-1之前的最高金额
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
