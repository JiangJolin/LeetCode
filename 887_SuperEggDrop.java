class Solution {
    Map<Integer, Integer> map;
    private int dp(int N, int K){
        if(K == 0 || N == 0) return 0;
        if(K == 1) return N;
        if(N == 0) return 1;

        if(!map.containsKey(N*1000+K)){
            int min_max = 0;
            int left = 1, right = N;
            int cur;
            while(left < right){
                cur = (left + right + 1)/2;
                int left_dp = dp(cur - 1, K - 1);
                int right_dp = dp(N - cur, K);
                if(left_dp <= right_dp){
                    left = cur;
                }else{
                    right = cur - 1;
                }
            }
            min_max = Math.max(dp(left - 1, K - 1), dp(N - left, K));
            map.put(N*1000+K, 1 + min_max);
            return 1 + min_max;
        }
        return map.get(N*1000+K);
    }
    public int superEggDrop(int K, int N) {
        map = new HashMap<>();
        
        return dp(N, K);
    }
}
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1];
        for(int j = 0; j <= K; j++){ //when N = 0, N = 1;
            dp[0][j] = 0;
            dp[1][j] = 1;
        }
        for(int i = 1; i <= N; i++){ // when K = 0, K = 1;
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for(int i = 2; i <= N; i++){
            for(int j = 2; j <= K; j++){
                // dp[i][j], 1 <= x <= i
                //non-decreasing dp[x - 1][j - 1]
                //non-increasing dp[i - x][j]
                
                int min_max = 0;
                int left = 1, right = i;
                int cur;
                while(left < right){
                    cur = (left + right + 1)/2;
                    if(dp[cur - 1][j - 1] <= dp[i - cur][j]){
                        left = cur;
                    }else{
                        right = cur - 1;
                    }
                }
                min_max = Math.max(dp[left - 1][j - 1], dp[i - left][j]);
                dp[i][j] = 1 + min_max;
            }
        }
        return dp[N][K];
    }
}