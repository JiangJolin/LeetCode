class Solution {
    public double myPow(double x, int n) {
        if (((n > 1000000) && (x < 1) && (x > -1)) || ((n < -1000000) && ((x > 1) || (x < -1)))) {
            return 0;
        }
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        if (n == 0) {
            return 1;
        } else if ((x == 0) || (x == 1) || (n == 1)) {
            return x;
        } else if (x == -1) {
            return 1 - (n % 2) * 2;
        } else {
            double ans = 1;
            for (int i = n; i > 0; i >>= 1) {
                if ((i & 1) == 1) {
                    ans *= x;
                }
                x *= x;
            }
            return ans;
        }
    }
}