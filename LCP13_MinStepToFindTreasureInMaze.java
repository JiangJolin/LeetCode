class Solution {
    public int minimalSteps(String[] maze) {
        int n = maze.length, m = maze[0].length();
        int D[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] board = new int[n][m];
        List<int[]> triggers = new ArrayList<>();
        List<int[]> stones = new ArrayList<>();
        int[] start = null;
        int[] end = null;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char temp = maze[i].charAt(j);
                if(temp == '.'){
                    board[i][j] = 0;
                }else if(temp == 'S'){
                    board[i][j] = 1;
                    start = new int[]{i, j};
                }else if(temp == 'O'){
                    board[i][j] = 2;
                    stones.add(new int[]{i, j});
                }else if(temp == 'M'){
                    board[i][j] = 3;
                    // System.out.printf("[Trigger %d @ (%d, %d)\n", triggers.size(), i, j);
                    triggers.add(new int[]{i, j});
                }else if(temp == 'T'){
                    board[i][j] = 4;
                    end = new int[]{i, j};
                }else{
                    board[i][j] = -1;
                }
            }
        }
        
        triggers.add(start);
        stones.add(end);
        int[][] dist = new int[triggers.size()][stones.size()]; //find the dist from triggers to stones
        //start -> (stone -> trigger) * n -> end
        Queue<int[]> q = new LinkedList<int[]>();
        int[][] access = new int[n][m];
        for(int i = 0; i < triggers.size(); i++) {
            q.clear();
            for (int[] a : access) {
                Arrays.fill(a, -1);
            }
            int[] t = triggers.get(i);
            access[t[0]][t[1]] = 0;
            q.offer(t);
            while (!q.isEmpty()) {
                int[] head = q.poll();
                for (int[] d: D) {
                    int x = head[0] + d[0];
                    int y = head[1] + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == -1 ||
                            access[x][y] != -1) {
                        continue;
                    }
                    access[x][y] = access[head[0]][head[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }

            for (int j = 0; j < stones.size(); j++) {
                int[] s = stones.get(j);
                if (access[s[0]][s[1]] == -1) {
                    dist[i][j] = 100000;
                } else {
                    dist[i][j] = access[s[0]][s[1]];
                }
            }
        }
        Map<Integer, Integer> moves = new HashMap<>();
        //dist: trigger i -> a stone(not include treasure) -> trigger j
        for (int i = 0; i < triggers.size() - 1; i++) {
            for (int j = i + 1; j < triggers.size(); j++) {
                int temp = 100000;
                for (int k = 0; k < stones.size() - 1; k++) {
                    temp = Math.min(temp, dist[i][k] + dist[j][k]);
                }
                moves.put(i * 101 + j, temp);
            }
        }
        int mask = (1 << (triggers.size() - 1)); //bitsmap to represent trigger visit order for each trigger
        //1111....1 means all visited, 0.....0 means initial, 
        int[][] dp = new int[mask][triggers.size()];
        mask --;
        for (int i = 0; i < triggers.size(); i++) {
            dp[0][i] = 100000;
        }
        dp[0][triggers.size() - 1] = 0;
        for (int i = 1; i <= mask; i++) {
            for (int j = 0; j < triggers.size(); j++) {
                dp[i][j] = 100000;
                if (((i >> j) & 1) == 0) { //this trigger is visited
                    continue;
                }
                int remove = i ^ (1 << j); //remove this trigger
                for (int k = 0; k < triggers.size(); k++) {
                    if(k == j) continue;
                    int from_k_j = k < j ? moves.get(k * 101 + j) : moves.get(j * 101 + k);
                    dp[i][j] = Math.min(dp[i][j], dp[remove][k] + from_k_j);
                }
            }
        }

        int ans = 100000;
        if (triggers.size() > 1) {
            for (int i = 0; i < triggers.size() - 1; i++) {
                ans = Math.min(ans, dp[mask][i] + dist[i][stones.size() - 1]);
            }
        } else {
            ans = dist[0][stones.size() - 1]; //
        }
        return ans == 100000 ? -1 : ans;
    }
}