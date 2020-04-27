class Solution {
    public int divide(int[] nums, int target, int l, int r){
        if(r == l + 1) return nums[l] == target ? l : -1;
        int ans = -1;
        //第一组条件为此分区为升序且target一定在该区间，第二组条件为此分区非升序且target可能在中间
        //如果满足两组条件其一，我们对该分区继续二分查找，否则返回ans=-1
        if((nums[l] < nums[r - 1] && nums[l] <= target && target <= nums[r - 1]) || 
           (nums[l] > nums[r - 1] && (nums[l] <= target || target <= nums[r - 1]))){
            ans = Math.max(divide(nums, target, l, (l + r)/2), divide(nums, target, (l + r)/2, r));
        }
        return ans;
    }
    public int search(int[] nums, int target) {
        //divide into 2, at most 1 partition is not in order
        int n = nums.length;
        if(n == 0) return -1;
        if(n == 1) return nums[0] == target ? 0 : -1;
        
        //如两部分都找不到target，ans得到max值为-1
        int ans = Math.max(divide(nums, target, 0, n/2), divide(nums, target, n/2, n));
        
        return ans;
    }
}