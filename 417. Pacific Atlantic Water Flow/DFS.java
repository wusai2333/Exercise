class Solution {
    private static final int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1},{0,1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, 0, i, matrix[0][i]);
            dfs(matrix, atlantic, m - 1, i, matrix[m-1][i]);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, i, 0, matrix[i][0]);
            dfs(matrix, atlantic, i, n - 1, matrix[i][n-1]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == true && atlantic[i][j] == true)
                    res.add(new int[]{i, j});
            }
        }
        return res;

    }

    private void dfs(int[][] matrix, boolean[][] visited, int i, int j, int height) {
        visited[i][j] = true;
        int m = matrix.length, n = matrix[0].length;
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] < height || visited[x][y]) continue;
            dfs(matrix, visited, x, y, matrix[x][y]);
        }
    }
}