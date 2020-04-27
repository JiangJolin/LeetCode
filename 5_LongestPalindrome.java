class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 1) return "";
        int bgn = 0, end = 0;
        for(int i = 1; i < s.length(); i++){
            int local_max = Math.max(expandFrom(s, i-1, i), expandFrom(s, i, i));
            if(local_max > end - bgn + 1){
                bgn = i - local_max / 2;
                end = i + (local_max - 1) / 2;
            }

        }
        return s.substring(bgn, end + 1);
    }

    private int expandFrom(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l --;
            r ++;
        }
        return r - l - 1;
    }
}