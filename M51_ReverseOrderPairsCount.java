class Solution {
    int ans = 0;
    public void mergeSort(int[] nums, int start, int end){
        if(start + 1 == end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid, end);

        int[] temp = new int[end - start];
        int i = start, j = mid, k = 0;
        while(i < mid && j < end){
            if(nums[i] <= nums[j]){
                // System.out.printf("%d-%d, produces %d pairs\n", nums[i], nums[j], j - mid);
                ans += j - mid;
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while(i < mid){
            ans += j - mid;
            // System.out.printf("left %d remained, produces %d pairs\n", nums[i], j - mid);
            temp[k++] = nums[i++];
        }
        while(j < end)
            temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, start, end - start);
        return;
    }
    public int reversePairs(int[] nums) {
        if(nums.length <= 1) return 0;
        mergeSort(nums, 0, nums.length);
        return ans;
    }
}