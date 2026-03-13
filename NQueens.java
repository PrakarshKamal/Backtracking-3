import java.util.*;

// Row wise 0 to n
// O(n * n!) time, O(n) space
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(0, n, board, ans);
        return ans;
    }

    private void helper(int row, int n, char[][] board, List<List<String>> ans) {
        if (row == n) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                path.add(new String(board[i])); // new string for each board
            }
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, board)) {
                board[row][col] = 'Q';
                helper(n, row+1, board, ans);
                board[row][col] = '.'; //backtrack
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] board) {
        // check vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // check left upper
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check right upper
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}