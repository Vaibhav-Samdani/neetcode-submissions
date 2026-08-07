class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i<n;i++){
            Arrays.fill(board[i],'.');
        }
        
        ans = new ArrayList<>();
        solve(board,0);

        return ans;
    }

    void solve(char[][] board, int i) {
        if (i == board.length) {
            List<String> curr = new ArrayList<>();
            for (int p = 0; p < board.length; p++) {
                StringBuilder st = new StringBuilder();
                for (int q = 0; q < board.length; q++) {
                    st.append(board[p][q]);
                }
                curr.add(st.toString());
            }

            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int k = 0; k < board.length; k++) {
            if (isPossible(board, i, k)) {
                board[i][k] = 'Q';
                solve(board, i + 1);
                board[i][k] = '.';
            }
        }
    }

    boolean isPossible(char[][] board, int i, int j) {
        for (int k = i; k >= 0; k--) {
            if (board[k][j] == 'Q')
                return false;
        }
        int start = i, end = j;
        while (start >= 0 && end >= 0) {
            if (board[start--][end--] == 'Q')
                return false;
        }
        start = i; 
        end = j;
        while (start >= 0 && end < board.length) {
            if (board[start--][end++] == 'Q')
                return false;
        }

        return true;
    }
}
