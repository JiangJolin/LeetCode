class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            int trial;
            if(height[left] < height[right]){
                trial = (right - left) * height[left];
                left ++;
            }else{
                trial = (right - left) * height[right];
                right --;
            }
            ans = Math.max(trial, ans);
            
        }
        return ans;
    }
}