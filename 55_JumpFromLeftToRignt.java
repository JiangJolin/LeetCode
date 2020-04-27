class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 0) return false;
        // int max_right = 0;
        // for (int i = 0; i < n; ++i) {
        //     if (i > max_right) break;
        //     max_right = Math.max(max_right, i + nums[i]);
        //     if (n - 1 <= max_right) {
        //         return true;
        //     }
        // }
        // return false;

        int pos = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= pos) {
                pos = i;
            }
        }
        return pos == 0;
    }
}