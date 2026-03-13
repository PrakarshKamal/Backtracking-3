// O(n * m * 3^L) time, O(L) space
class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        int[][] dirs = new int[][] {
            {0,1},{0,-1},{1,0},{-1,0}
        };

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, n, m, word, 0, dirs, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int n, int m, String word, int wordIdx, int[][] dirs, boolean[][] visited) {
        if (board[i][j] != word.charAt(wordIdx)) return false;

        if (wordIdx == word.length() - 1) return true;

        visited[i][j] = true; // mark as visited

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && c >= 0 && r < n && c < m && !visited[r][c]) {
                if (dfs(board, r, c, n, m, word, wordIdx+1, dirs, visited)) {
                    visited[r][c] = false;
                    return true;
                }
            }
        }

        visited[i][j] = false; // backtrack

        return false;
    }
}