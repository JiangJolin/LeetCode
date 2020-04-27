class Solution {
    public int countLargestGroup(int n) {
        if(n < 9) return n;
        int[] bit_sum = new int[37];
        for(int i = 1; i <= n; i ++){
            int temp = i;
            int sum = 0;
            while(temp > 0){
                sum += temp % 10;
                temp /= 10;
            }
            bit_sum[sum] ++;
        }
        int max = 1;
        int ans = 1;
        for(int i = 1; i < 38; i++){
            if(bit_sum[i] > max){
                max = bit_sum[i] ;
                ans = 1;
            }else if(bit_sum[i]  == max){
                ans += 1;
            }else{
                break;
            }
        }

        return ans;
    }
}