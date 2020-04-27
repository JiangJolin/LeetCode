class Solution {

    public int numWays(int n, int[][] relation, int k) {
        boolean[][] r_map = new boolean[n][n];
        for(int i = 0; i < relation.length; i ++){
            r_map[relation[i][1]][relation[i][0]] = true;
        }
        Queue <Integer> temp1 = new LinkedList<Integer>();
        for(int i = 0; i < n; i ++){
            if(r_map[n - 1][i]) temp1.offer(i);
        }
        k --;
        while(k > 0){
            Queue <Integer> temp2 = new LinkedList<Integer>();
            //System.out.printf("level%d: ", k);
            while(!temp1.isEmpty()){
                int people = temp1.poll();
                //System.out.printf("%d ", people);
                for(int i = 0; i < n; i ++){
                    if(r_map[people][i]) temp2.offer(i);
                }
            }
            temp1 = temp2;
            k --;
        }
        int ans = 0;
        while(!temp1.isEmpty()){
            //System.out.printf("level%d: ", k);
            //System.out.printf("%d ", temp1.peek());
            if(temp1.poll() == 0) ans += 1;
        }
        return ans;
        
    }
}