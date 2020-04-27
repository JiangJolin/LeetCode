class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int sum = 0;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--){
            dp[i] = Integer.MIN_VALUE;
            sum += stoneValue[i];
            for(int j = i + 1; j <= i + 3 && j <= n; j ++){
                dp[i] = Math.max(dp[i], sum - dp[j]);
            }
        }
        
        if(dp[0] < sum - dp[0]){
            return "Bob";
        }else if(dp[0] == sum - dp[0]){
            return "Tie";
        }else{
            return "Alice";
        }
        
    }
}