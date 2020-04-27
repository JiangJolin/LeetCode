class Solution {
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int ans = 0;
        int left = 0, right = height.length - 1;
        int l_max = 0, r_max = 0;
        while(left <= right){
            //use the lower one of the current peeks on the two side
            if(l_max <= r_max){ //left_max is lower. 
                if(height[left] > l_max){ //update left_max
                    l_max = height[left];
                }else{ //get the accumulating value from left
                    ans += l_max - height[left];
                }
                left ++;
            }else{ // right max is lower
                if(height[right] > r_max){
                    r_max = height[right];
                }else{//get the accumulating value from right
                    ans += r_max - height[right];
                }
                right --;
            }
        }
        return ans;
    }
}