class Solution {
    private static final int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length, n = board[0].length;
        // check the left and right boarder and turn boarder 'O' into '1';
        for (int i = 0; i < m; i++) {
            check(board, i, 0, m, n);
            if (n > 1)
                check(board, i, n-1, m, n);
        }
        // check the upper and lower boarder
        for (int j = 0; j < n; j++) {
            check(board, 0, j, m, n);
            if (m > 1)
                check(board, m-1, j, m ,n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void check(char[][] board, int i, int j, int m, int n) {
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x <= 0||x >= m-1||y <= 0|| y >= n-1) { // A trick to avoid stackoverflow.
                    continue;
                }
                check(board, x, y, m, n);
            }
        }
    }
}