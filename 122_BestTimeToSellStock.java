//执行用时 :1 ms, 在所有 Java 提交中击败了99.99%的用户
//内存消耗 :37 MB, 在所有 Java 提交中击败了71.21%的用户
class Solution {
    public int maxProfit(int[] prices) {
        // int len = prices.length;
        if(prices.length <= 1) return 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
        // int[][] dp = new int[len][2];
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0];
        // for(int i = 1; i < len; i++){
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        //     dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        // }
        // return dp[len - 1][0];
    }
}