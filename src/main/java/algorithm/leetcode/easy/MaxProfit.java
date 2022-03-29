package algorithm.leetcode.easy;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/22 0022
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;  //
        dp[1] = -prices[0]; //
        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[0],dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], - prices[i]);
        }
        return dp[0];
    }

    /**
     * 记录最大利润和最小价格，当前价格减去最小价格比最大利润大，则替换最大利润
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
