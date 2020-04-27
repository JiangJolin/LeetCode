public class Solution {
    public int numOfWays(int n) {
            if (n == 0)
                return 0;
            else if (n == 1)
                return 12;
            long mod = 1000000007;
            long  three = 6, two = 6;
            for(int i = 2; i <=n; i++){
                long  new_two = (two * 3) % mod + three * 2 % mod;
                long  new_three = two * 2 % mod + three * 2 % mod;
                three = new_three;
                two = new_two;
            }
            return (int)((three + two)%mod);
    }
}