public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; //row
        int n = grid[0].length; //colomn
        for (int i = 1; i < m; i++)
            grid[i][0] += grid[i-1][0];
        for (int i = 1; i < n; i++)
            grid[0][j] += grid[0][i-1];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
    }
}
