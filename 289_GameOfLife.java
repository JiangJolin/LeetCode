// class Solution {
//     public:
//         void gameOfLife(vector<vector<int>>& board) {
//             int m = board.size(), n = board[0].size();
//             int start_x, end_x, start_y, end_y, alives;
//             for(int i = 0; i < m; i++){
//                 for(int j = 0; j < n; j++){
//                     alives = 0; //record the #of live cells around.
    
//                     start_x = i > 0 ? i - 1 : 0;
//                     end_x = i < m - 1 ? i + 2 : m;
//                     start_y = j > 0 ? j - 1 : 0;
//                     end_y = j < n - 1 ? j + 2 : n;
                    
//                     for(int x = start_x; x < end_x; x++){
//                         for(int y = start_y; y < end_y; y++){
//                             if((x == i) && (y == j)) continue;
//                             alives += board[x][y] & 1;
//                         }
//                     }

//                     if((board[i][j] & 1) * alives == 3 || (board[i][j] & 1) + alives == 3){
//                         board[i][j] |= 2;
//                     }
//                 }
    
//             }
    
//             for(int i = 0; i < m; i++){
//                 for(int j = 0; j < n; j++){
//                     board[i][j] >>= 1;
//                 }
//             }
//         }
// };

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int start_x, end_x, start_y, end_y, alives;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                alives = 0; //record the #of live cells around.

                start_x = i > 0 ? i - 1 : 0;
                end_x = i < m - 1 ? i + 2 : m;
                start_y = j > 0 ? j - 1 : 0;
                end_y = j < n - 1 ? j + 2 : n;
                
                for(int x = start_x; x < end_x; x++){
                    for(int y = start_y; y < end_y; y++){
                        if((x == i) && (y == j)) continue;
                        alives += board[x][y] % 2;
                    }
                }
                //cell_state    #alives       nxt_state
                //1         +   2        = 3, 1
                //1         *   3        = 3, 1
                //0         +   3        = 3, 1
                //0         +/* others  != 3, 0
                if(board[i][j] % 2 + alives == 3 || board[i][j] % 2 * alives == 3){
                    board[i][j] += 2;
                }
            }

        }
        //Get all new state and then update
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] /= 2;
            }
        }

    }
}
