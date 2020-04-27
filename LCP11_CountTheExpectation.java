class Solution {
    // public int permutation(int m,int n){
    //     if(n==0){
    //         return 1;
    //     }
    //     int result=1;
    //     for(int k=n;k>=n-m+1;k--){
    //         result*=k;
    //     }
    //     return result;
    // }
    
    public int expectNumber(int[] scores) {
        Arrays.sort(scores);
        int ans = 0;
        int cur = 0;
        while(cur < scores.length){
            if(cur == scores.length - 1 || scores[cur+1] != scores[cur]){
                ans ++;
            }else{
                // int count = 1;
                while(cur < scores.length - 1 && scores[cur+1] == scores[cur]){
                    cur++;
                    // count ++;
                }
                ans ++;
//                 if(count == 2){
//                     // System.out.println("E(0,2|2) = 1");
//                     ans += 1;
//                 }else{
//                     int base = (int) Math.pow(permutation(count, count), 2);
//                     int temp = 0;
//                     for(int i = 1; i < count - 1; i++){
//                         temp += i * (int) Math.pow(permutation(i, count), 2) / permutation(i, i) * permutation(count - i, count - i) * (count - i - 1);
//                         // System.out.printf("E(%d|%d) = %d\n", i, count, temp);
//                     }
//                     temp += count * permutation(count, count);
//                     // System.out.printf("E(%d|%d) = %d\n", count, count, temp);
//                     ans += temp / base;
//                 }
                
            }
            cur ++;
        }
        return ans;
    }
}