import java.util.*;
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        if(seq.length() == 0) return null;
        int n = seq.length();
        int[] depth = new int[n]; //to record depth
        Stack<Integer> p_stack = new Stack<Integer>();
        int d = -1;
        for(int i = 0; i < n; i++){
            if(seq.charAt(i) == '('){
                p_stack.push(i);
                d++;
            }else{
                depth[p_stack.peek()] = d--;
                depth[i] = depth[p_stack.pop()];
            }
        }

        
        int flag = 0;
        int temp = 0;
        int cur = 1;
        while(cur < n){
            if(depth[cur] != temp){
                flag = 1 - flag;
                temp = depth[cur];
            }
            depth[cur] = flag;
            cur ++;
        }

        return depth;
    }
}