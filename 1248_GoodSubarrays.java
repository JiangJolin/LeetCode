class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> odds = new ArrayList<Integer>();
        int pre = 0, ans = 0, odd_cnt = 0;
        odds.add(-1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                odds.add(i);
                odd_cnt ++;
            }
            if(odd_cnt > k){
                ans += (odds.get(pre + 1) - odds.get(pre)) * (i - odds.get(pre + k));
                odd_cnt -= 1;
                pre ++;
            }
        }
        if(odd_cnt == k){
            ans += (odds.get(pre + 1) - odds.get(pre)) * (nums.length - odds.get(pre + k));
        }
        return ans;
    }
}