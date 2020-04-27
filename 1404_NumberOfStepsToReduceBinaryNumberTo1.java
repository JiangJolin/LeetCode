class Solution {
    public int numSteps(String s) {
        if(s.length() == 0) return 0;

        int ans = 0;
        int carry = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(i == 0 && carry == 0) break;
            if(s.charAt(i) - '0' != carry){
                carry = 1;
                ans += 1;
            }
            ans += 1;
        }
        return ans;
    }
}