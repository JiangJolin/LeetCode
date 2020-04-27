import java.util.*;
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int ans = 0;
        int n = satisfaction.length;
        Arrays.sort(satisfaction); //ascending order
        int sum = 0;
        for(int index = n - 1; index >= 0; index--){
            sum += satisfaction[index];
            if(sum > 0){ //we can have a larger result by joining the current number
                ans += sum;
            }else{ //does not lead to a larger result
                break;
            }
        }

        return ans;
    }
}