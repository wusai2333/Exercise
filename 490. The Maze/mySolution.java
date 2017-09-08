class Solution {
    private static final int[][] dirs = new int[][]{{0,1}, {0, -1}, {1,0}, {-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        dfs(maze, start, destination, visited, 10);
        return visited[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited, int from) {
        if (visited[start[0]][start[1]]) return;
        visited[start[0]][start[1]] = true;
        
        int cantGo = from % 2 == 1? from - 1: from + 1;
        for (int i = 0; i < 4; i++) {
            if (cantGo == i) continue;
            int x = start[0];
            int y = start[1];
            while (canRoll(maze, x, y, i)) {
                x += dirs[i][0];
                y += dirs[i][1];               
            }
            if (start[0] != x || start[1] != y) {
                dfs(maze, new int[]{x, y}, destination, visited, i);
            }
        }
    }

    private boolean canRoll(int[][] maze, int x, int y, int i) {
        x += dirs[i][0];
        y += dirs[i][1];
        boolean canRoll = (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0);
        return canRoll;
    }
}