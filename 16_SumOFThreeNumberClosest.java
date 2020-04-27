
//执行用时 : 2 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 : 36.7 MB, 在所有 java 提交中击败了84.07%的用户
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        int temp;
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r && sum != target) {
                temp = nums[i] + nums[l] + nums[l + 1];
                if (temp > target) {
                    if (Math.abs(temp - target) < Math.abs(sum - target)) {
                        sum = temp;
                    }
                    break;
                }
                temp = nums[i] + nums[r - 1] + nums[r];
                if (temp < target) {
                    if (Math.abs(temp - target) < Math.abs(sum - target)) {
                        sum = temp;
                    }
                    break;
                }
                temp = nums[i] + nums[l] + nums[r];
                if (Math.abs(temp - target) < Math.abs(sum - target)) {
                    if (temp == target)
                        return temp;
                    sum = temp;
                }
                if (temp > target) {
                    r--;
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                } else {
                    l++;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                }
            }
            while (i < len - 2 && nums[i] == nums[i + 1])
                i++;
        }
        return sum;
    }
}