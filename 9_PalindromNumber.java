class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        if(x < 10) return true;
        long res = 0;
        int x_dup = x;
        while(x > 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        if(res != (int)res) return false;
        if(x_dup == (int)res) return true;
        return false;
        
        // String x_s = String.format("%d", x);
        // int l = 0, r = x_s.length()-1;
        // while(l < r){
        //     if(x_s.charAt(l) != x_s.charAt(r)) return false;
        //     l++;
        //     r--;
        // }
        // return true;
        // if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        // if(x < 10) return true;
        // int reverse_right = 0;
        // while(x > reverse_right){
        //     reverse_right = reverse_right * 10 + x % 10;
        //     x /= 10;
        // }
        // if(x == reverse_right) return true;
        // if(x == reverse_right / 10) return true;
        // return false;
    }
}