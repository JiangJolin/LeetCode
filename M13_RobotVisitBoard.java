class Solution {
    int ans, row, col, limit;
    boolean[] visit;

    private void dfs(int i, int j){
        visit[i*col+j] = true;
        if(i + 1 < row && visit[i*col+col+j] == false){
            int temp_i = i+1, temp_j = j;
            int bit_sum = 0;
            while(temp_i > 0){
                bit_sum += temp_i % 10;
                temp_i /= 10;
            }
            while(temp_j > 0){
                bit_sum += temp_j % 10;
                temp_j /= 10;
            }
            if(bit_sum <= limit){
                ans ++;
                dfs(i+1, j);
            }
        }
        if(j + 1 < col && visit[i*col+j+1] == false){
            int temp_i = i, temp_j = j+1;
            int bit_sum = 0;
            while(temp_i > 0){
                bit_sum += temp_i % 10;
                temp_i /= 10;
            }
            while(temp_j > 0){
                bit_sum += temp_j % 10;
                temp_j /= 10;
            }
            if(bit_sum <= limit){
                ans ++;
                dfs(i, j+1);
            }
        }
    }
    
    public int movingCount(int m, int n, int k) {
        ans = 1;
        row = m;
        col = n;
        limit = k;
        visit = new boolean[m*n];
        dfs(0, 0);
        return ans;
    }
}