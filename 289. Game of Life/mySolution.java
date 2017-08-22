import java.util.Arrays;

class Solution {
    private static final int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        int[][] nextState = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(board, nextState, i, j, m, n);
            }
        }
        
        for (int i = 0; i < m; i++) {
            board[i] = Arrays.copyOf(nextState[i], n);
        }
    }

    private void check(int[][] board, int[][] nextState, int i, int j, int m, int n) {
        int liveCount = 0;
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (board[x][y] == 1) liveCount++;
        }
        if (liveCount < 2) nextState[i][j] = 0;
        else if (liveCount > 3) nextState[i][j] = 0;
        else if (liveCount == 3) nextState[i][j] = 1;
        else nextState[i][j] = board[i][j];
    }
}