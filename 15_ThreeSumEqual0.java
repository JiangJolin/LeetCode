import java.util.Arrays;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int L, R;
        for(int i = 0; i < n - 2; i++){
            if(nums[i] > 0) break;
            L = i+1;
            R = n - 1;
            while(L < R){
                int temp = nums[i] + nums[L] + nums[R];
                if(temp > 0){
                    R --;
                }else if(temp < 0){
                    L ++;
                }else{
                    List<Integer> good_ans = new ArrayList<Integer>();
                    good_ans.add(nums[i]);
                    good_ans.add(nums[L]);
                    good_ans.add(nums[R]);
                    ans.add(good_ans);
                    while(L < R && nums[R-1] == nums[R]) R--;
                    while(L < R && nums[L+1] == nums[L]) L++;
                    L++;
                    R--;
                }
            }
            while(i < n - 2 && nums[i+1] == nums[i]) i++;
        }
        return ans;
    }
}