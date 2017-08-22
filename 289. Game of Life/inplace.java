public class Solution {
    private static final int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                checkAndUpdate(board, i, j, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private void checkAndUpdate(int[][] board, int i, int j, int m, int n) {
        int liveCount = 0;
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if ((board[x][y] & 1) == 1) liveCount++;
        }
        if (board[i][j] == 1 && liveCount >= 2 && liveCount <= 3) {
            board[i][j] = 3;
        }
        if (board[i][j] == 0 && liveCount == 3) {
            board[i][j] = 2;
        }
    }
}