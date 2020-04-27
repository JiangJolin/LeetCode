class Solution {
    Set<Integer> visited = new HashSet<>();
    int col;
    
    public void dfs(int[][] M, int i){
        if(visited.contains(i)) return;
        visited.add(i);
        for(int j = 0; j < col; j++){
            if(M[i][j] == 1) dfs(M, j);
        }
    }

    public int findCircleNum(int[][] M) {
        int row = M.length;
        if(row == 0) return 0;
        col = M[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            if(!visited.contains(i)){
                count ++;
                dfs(M, i);
            }
        }
        return count;
    }
}