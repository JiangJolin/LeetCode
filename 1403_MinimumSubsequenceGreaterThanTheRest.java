import java.util.*;
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 1){
            ans.add(nums[0]);
            return ans;
        }
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int sub_sum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            int temp = nums[i];
            ans.add(temp);
            if(sum - temp < sub_sum + temp){
                break;
            }else{
                sum -= temp;
                sub_sum += temp;
            }
        }
        return ans;
    }
}