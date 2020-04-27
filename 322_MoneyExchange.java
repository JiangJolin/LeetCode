//执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.38%的用户
/*
 * DFS
 */
import java.util.*;
class Solution {
    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dfs(int[] coins,int index,int amount,int count){
        if(index < 0){
            return;
        }
        for(int c_num = amount / coins[index]; c_num >= 0; c_num--){
            int remain = amount - c_num * coins[index];
            int new_cnt = count + c_num;
            if(remain == 0){
                ans = Math.min(ans, new_cnt);
                break;//剪枝1
            }
            if(new_cnt + 1 >= ans){
                break; //剪枝2
            }
            dfs(coins, index-1, remain, new_cnt);
        }
    }

}
/*
 * DP
 */
// import java.util.*;
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if(amount == 0) return 0;
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0;
//         for (int i = 1; i <= amount; i++) {
//             for (int j = 0; j < coins.length; j++) {
//                 if (coins[j] <= i) {
//                 dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                 }
//             }
//         }
//         return dp[amount] > amount ? -1 : dp[amount];
//     }
//     }
// }