<<<<<<< HEAD
public class Solution {
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n==0) return 0;
        m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ) {
                if (grid[i][j] == '1') {
                    count += sink(grid, i, j);
                }
            }
        }
    }
    private int sink(char[][] grid, int i, int j) {
        if (i < 0||i == grid.length||j < 0|| j == grid[0].length||grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        sink(grid, i-1, j);
        sink(grid, i+1, j);
        sink(grid, i, j-1);
        sink(grid, i, j+1);
        return 1;
    }
}
=======
public class Solution {
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n==0) return 0;
        m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ) {
                if (grid[i][j] == '1') {
                    count += sink(grid, i, j);
                }
            }
        }
    }
    private int sink(char[][] grid, int i, int j) {
        if (i < 0||i == grid.length||j < 0|| j == grid[0].length||grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        sink(grid, i-1, j);
        sink(grid, i+1, j);
        sink(grid, i, j-1);
        sink(grid, i, j+1);
        return 1;
    }
}
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
