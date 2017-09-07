class Solution {
    static final int[] dirs = new int[]{0, 1, 0, -1, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dist = new int[maze.length][maze[0].length];
        dist[start[0]][start[1]] = 1;
        dfs(maze, start[0], start[1], destination, dist);
        return dist[destination[0]][destination[1]] - 1;
    }

    private void dfs(int[][] maze, int row, int col, int[] destination, int[][] dist) {
        if (row == destination[0] && col == destination[1]) return;
        int m = maze.length, n = maze[0].length;
        for (int d = 0; d < 4; d ++) {
            int i = row, j = col, p = dirs[d], q = dirs[d+1], len = dist[row][col];
            while (i + p >= 0 && i + p < m && j + q >= 0 && j + q < n && maze[i + p][j + q] == 0) {
                i += p;
                j += q;
                len ++;
            }
            if (dist[i][j] > 0 && len >= dist[i][j]) continue;
            dist[i][j] = len;
            dfs(maze, i, j, destination, dist);
        }
    }
}