class Solution {
    // static Comparator<int[]> cmp = new Comparator<int[]>() {
    //     public int compare(int[] a, int[] b) {
    //         if(a[0] != b[0]){
    //             return a[0] - b[0];
    //         }else if(a[1] != b[1]){
    //             return a[1] - b[1];
    //         }else{
    //             return a[2] - b[2];
    //         }
    //     }
    // };
    
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        // Map<Integer, Map<Integer, Map<Integer, Integer>>> global = new HashMap<>();
        // for(int i = 0; i < requirements.length; i++){
        //     Map<Integer, Set<Integer>> local_1;
        //     if(!global.containsKey(requirements[i][0])){
        //         local_1 = new HashMap<>();
        //         global.put(requirements[i][0], local_1);
        //     }else{
        //         local_1 = global.get(requirements[i][0]);
        //     }
        //     Map<Integer, Integer> local_2;
        //     if(!local_1.containsKey(requirements[i][1])){
        //         local_2 = new HashMap<>();
        //         local_1.put(requirements[i][1], local_2);
        //     }else{
        //         local_2 = local_1.get(requirements[i][1]);
        //     }
        //     local_2.put(requirements[i][2], i);
        //     local_1.put(requirements[i][1], local_2);
        //     global.put(requirements[i][0], local_1);
        // }
        // int C = 0, R = 0, H = 0;
        // int[] ans = new int[requirements.length];
        // Arrays.fill(ans, -1);
        // int day = 0;
        // while(true){
        //     for(int i < C; i >= 0; i--){
        //         for(int )
        //     }
        // }
        // Arrays.sort(requirements, (v1, v2) -> v1[0] - v2[0]);
        // 
        int[] ans = new int[requirements.length];
        if(requirements[0][0] == 0 && requirements[0][1] == 0 && requirements[0][2] == 0) return ans;
        for(int i = 1; i < increase.length; i++){
            increase[i][0] += increase[i-1][0];
            increase[i][1] += increase[i-1][1];
            increase[i][2] += increase[i-1][2];
        }
        // int[] ans = new int[requirements.length];
        // Arrays.fill(ans, -1);
        // int day = 0;
        for(int i = 0; i < requirements.length; i++){
            int cur = 0;
            while(increase[cur][0] < requirements[i][0] || increase[cur][1] < requirements[i][1] || increase[cur][2] < requirements[i][2]){
                cur ++;
                if(cur == increase.length) break;
            }
            ans[i] = cur == increase.length ? -1 : cur+1;
        }
        return ans;
    }
}