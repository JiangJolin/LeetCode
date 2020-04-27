class Solution {
    public int minJump(int[] jump) {
        if(jump.length == 1) return 1;
        int[] dp = new int[jump.length];
        int[] maxDist = new int[jump.length + 1];
        //index i stores the max distance reachable by i+1 jumps
        int maxCur = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int ans = jump.length + 1;
        for(int i = 0; i < jump.length; i ++){
            if(i >= maxDist[maxCur]){
                maxCur ++;
            }
            dp[i] = Math.min(dp[i], maxCur + 1);
            if(i + jump[i] > maxDist[dp[i] + 1]){
                maxDist[dp[i] + 1] = i + jump[i];
                if(i + jump[i] >= jump.length){
                    ans = Math.min(ans, dp[i] + 1);
                }
            }
            if(i + jump[i] < jump.length) dp[i + jump[i]] = Math.min(dp[i + jump[i]], dp[i] + 1);
        }
        return ans;
    }
}