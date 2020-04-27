//执行用时 :7 ms, 在所有 Java 提交中击败了99.88%的用户
//内存消耗 :36.4 MB, 在所有 Java 提交中击败了100.00%的用户
class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for(int i = 2; i <= n; i++){
            int offset = m % i;
            ans = (ans + offset) % i;
        }
        return ans;
    }
}