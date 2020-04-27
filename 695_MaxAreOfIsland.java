class Solution {
    Set<Integer> visited; //可省略，把访问过的grid值改为1，效果一下
    int m, n;
    
    public int dfs(int[][] grid, int i, int j){
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) return 0;
        if(visited.contains(i*51 + j)) return 0;

        int local_ans = 1;
        visited.add(i*51 + j);
        local_ans += dfs(grid, i, j + 1);
        local_ans += dfs(grid, i, j - 1);
        local_ans += dfs(grid, i + 1, j);
        local_ans += dfs(grid, i - 1, j);
        return local_ans;
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        int ans = 0;
        visited = new HashSet<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        
        return ans;
    }
}