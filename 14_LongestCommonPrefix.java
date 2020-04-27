class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int ans = strs[0].length();
        for(int i = 1; i < strs.length && ans > 0; i++){
            ans = Math.min(ans, strs[i].length());
            for(int j = 0; j < ans; j++){
                if(strs[i].charAt(j) != strs[0].charAt(j)){
                    ans = j;
                }
            }
        }
        return strs[0].substring(0, ans);
    }
}