class Solution {
    static final int[][] dirs = new int[][]{{0,1}, {0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dist = new int[maze.length][maze[0].length];
        dfs(maze, start, destination, 1, dist, 10);
        return dist[destination[0]][destination[1]] - 1;
    }
    // It will get a TLE.. DFS
    // private void dfs(int[][] maze, int row, int col, int[] destination, int[][] dist) {
    //     if (row == destination[0] && col == destination[1]) return;
    //     int m = maze.length, n = maze[0].length;
    //     for (int d = 0; d < 4; d ++) {
    //         int i = row, j = col, p = dirs[d], q = dirs[d+1], len = dist[row][col];
    //         while (i + p >= 0 && i + p < m && j + q >= 0 && j + q < n && maze[i + p][j + q] == 0) {
    //             i += p;
    //             j += q;
    //             len ++;
    //         }
    //         if (dist[i][j] > 0 && len >= dist[i][j]) continue;
    //         dist[i][j] = len;
    //         dfs(maze, i, j, destination, dist);
    //     }
    // }

    private void dfs(int[][] maze, int[] start, int[] destination, int curDist, int[][] dist, int from) {
        if (dist[start[0]][start[1]] > 0 && dist[start[0]][start[1]] <= curDist) return;
        dist[start[0]][start[1]] = curDist;
        if (Arrays.equals(start, destination)) {
            return;
        }
        int  cantGo = from % 2 == 1 ? from - 1: from + 1;
        // try to roll in all four directions
        for (int i = 0; i < 4; i++) {
            if (i == cantGo) {
                continue;
            }
            int newDist = curDist;
            int x = start[0];
            int y = start[1];
            while (canRoll(maze, x, y, i)) {
                x += dirs[i][0];
                y += dirs[i][1];
                newDist++;
            }
            if (start[0] != x || start[1] != y) {
                dfs(maze, new int[]{x, y}, destination, newDist, dist, i);
            }
        }
    }

    private boolean canRoll(int[][] maze, int x, int y , int i) {
        x += dirs[i][0];
        y += dirs[i][1];
        boolean canRoll = (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0);
        return canRoll;
    }
}