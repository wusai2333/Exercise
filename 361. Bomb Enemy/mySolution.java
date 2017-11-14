class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int row = 0;
        int[] col = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') continue;
                if (j == 0 || grid[i][j-1] == 'W') {
                    row = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        row += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    col[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        col[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0')
                    res = (row + col[j] > res) ? row + col[j] : res;
            }
        }
        return res;
    }
}