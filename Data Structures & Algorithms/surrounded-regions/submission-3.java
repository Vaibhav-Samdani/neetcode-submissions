class Solution {
    int[][] dist ={{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 1. Mark all border-connected 'O' as 'Y'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }

        // 2. Surrounded 'O' -> 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


        // 3. Restore 'Y' -> 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int i , int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;

        if(board[i][j] != 'O') return;
        board[i][j] = 'Y';

        for(int k = 0; k<dist.length;k++){
            int ni = i + dist[k][0], nj = j + dist[k][1];
            dfs(board,ni,nj);
        }

    }

}
