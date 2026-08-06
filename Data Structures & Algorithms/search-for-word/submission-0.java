class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (solve(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean solve(char[][] board, String word, int i, int j, int w) {
        if (w == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        boolean ans = false;
        if (word.charAt(w) != board[i][j]) {
            return false;
        } else {
            char ch = board[i][j];
            board[i][j] = '.';
            ans = solve(board, word, i + 1, j, w + 1) || solve(board, word, i, j + 1, w + 1)
                    || solve(board, word, i - 1, j, w + 1) || solve(board, word, i, j - 1, w + 1);
            board[i][j] = ch;
        }

        return ans;
    }
}