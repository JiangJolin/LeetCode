class Solution {
    public int splitArray(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];


        int limit = 1000000;
        int[] arr = new int[20];
        int inf = (int) 1e9;
        int[] registries = new int[limit + 1]; // stores seq # using each factor;
        Arrays.fill(registries, inf);

        for (int i = 0; i < n; i++) {
            dp[i][0] = i == 0 ? 1 : Math.min(dp[i - 1][0], dp[i - 1][1]) + 1; //seg# as start
            dp[i][1] = inf; //seq# as end
            int len = factorize(nums[i], arr);
            // System.out.print(nums[i]);
            for (int j = 0; j < len; j++) {//find last with minfac > 1
                int factor = arr[j];
                // System.out.printf(": factor %d  ", factor);
                dp[i][1] = Math.min(dp[i][1], registries[factor]); //update seq# as end
                registries[factor] = Math.min(registries[factor], dp[i][0]); //update seg# using factor
            }
            // System.out.printf("<%d, %d>\n", dp[i][0], dp[i][1]);
        }

        int ans = Math.min(dp[n - 1][0], dp[n - 1][1]);
        return ans;
    }

    public int factorize(int n, int[] arr) {
        int cur = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            arr[cur++] = i;
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n > 1) {
            arr[cur++] = n;
        }
        return cur;
    }
}