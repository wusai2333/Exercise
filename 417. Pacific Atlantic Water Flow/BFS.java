class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return res;
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            pacific[0][i] = true;
            atlantic[m-1][i] = true;
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{m-1, i});
        }
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, n-1});
        }
        
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == true && atlantic[i][j] == true)
                    res.add(new int[]{i, j});
            }
        }
        return res;
    }
    
    void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir: dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y])
                    continue;
                if (matrix[x][y] >= matrix[pos[0]][pos[1]]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}