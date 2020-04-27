//执行用时 : 1 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 : 38.4 MB, 在所有 java 提交中击败了58.49%的用户

class Solution {
    public int countBattleships(char[][] board) {
        int col = board.length;
        int row = board[0].length;
        int count = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (board[i][j] == 'X') {
                    if (((i > 0) && board[i - 1][j] == 'X') || ((j > 0) && board[i][j - 1] == 'X')) {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}