//执行用时 : 1 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 : 33.5 MB, 在所有 java 提交中击败了70.16%的用户

class Solution {
    public int binaryGap(int N) {
        int ans = 0;
        int temp = 0;
        while(N > 0){
            if(temp > 0){
                if((N & 1) == 1){
                    ans = ans > temp? ans : temp;
                    temp = 0;
                }else{
                    temp ++;
                }
            }
            if(temp == 0){
                if((N & 1) == 1){
                    temp ++;
                }
            }
            N = N >> 1;
        }
        return ans;
    }
}