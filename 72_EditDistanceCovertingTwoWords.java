class Solution {
    public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    // 有一个字符串为空串
    if (n * m == 0)
      return n + m;

    int[][] dp = new int[n + 1][m + 1];

    // 边界状态初始化
    //# of operations needed to covert word1[i:n] to ''
    for (int i = 0; i < n + 1; i++) {
      dp[i][m] = n - i;
    }
    //# of operations needed to covert word2[j:m] to ''
    for (int j = 0; j < m + 1; j++) {
      dp[n][j] = m - j;
    }

    // 计算所有 DP 值, bottom to top
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        //int from_right = dp[i + 1][j] + 1; //delete one
        //int from_down = dp[i][j + 1] + 1; //add one
        //int from_rightdown = dp[i + 1][j + 1]; //match, no operation
        //int from_rightdown = dp[i + 1][j + 1] + 1; //replace one
        if (word1.charAt(i) != word2.charAt(j)){
            dp[i][j] = Math.min(dp[i + 1][j] + 1, Math.min(dp[i][j + 1] + 1, dp[i + 1][j + 1] + 1));
        }else{
           dp[i][j] = Math.min(dp[i + 1][j] + 1, Math.min(dp[i][j + 1] + 1, dp[i + 1][j + 1]));
        }
      }
    }
    return dp[0][0];
  }
}