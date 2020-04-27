//执行用时 :1 ms, 在所有 Java 提交中击败了99.99%的用户
//内存消耗 :37 MB, 在所有 Java 提交中击败了77.89%的用户
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int profit = 0;
        int cost = prices[0];
        for(int i = 1; i < prices.length; i ++){
            if (prices[i] < cost){
                cost = prices[i];
            }else{
                profit = Math.max(prices[i] - cost, profit);
            }
        }
        return profit;
    }
}