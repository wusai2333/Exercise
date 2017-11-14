// DFS is bad, it needs memorization otherwise it will get a TLE;
class Solution {
    private static final int[][] dirs = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2},{1, 2}, {2, -1}, {2, 1}};
    public double knightProbability(int N, int K, int r, int c) {
        int[] count = new int[1];
        boolean[][] visited = new boolean[N][N];
        
        dfs(N, K, r, c, count, visited);
        return (1.0 * count[0]) / Math.pow(8, K);
    }
    
    private void dfs(int N, int K, int r, int c, int[] count, boolean[][] visited) {
        if (r < 0 || r >= N || c < 0 || c >= N) return;
        visited[r][c] = true;
        if (K == 0) {
            count[0]++;
            return;
        }
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            dfs(N, K - 1, x, y, count, visited);
        }
    }
}
// DP solution decrease the time complexity
class Solution {
    private static final int[][] dirs = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2},{1, 2}, {2, -1}, {2, 1}};
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dp0 = new int[N][N];
        for (int[] row : dp0) Arrays.fill(row, 1);
        for (int l = 0; l < K; l++) {
            int[][] dp1 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir: dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= N || y < 0 || y >= N) continue;
                        dp1[i][j] += dp0[x][y];
                    }
                }
            }
            dp0 = dp1;
        }
        return 1.0 * dp0[r][c] / Math.pow(8, K);
    }
}