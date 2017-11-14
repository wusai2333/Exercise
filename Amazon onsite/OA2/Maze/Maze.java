import java.util.*;
public class Maze {
    private static final int[][] dirs = new int[][]{{-1,0}, {1,0},{0,-1},{0,1}};
    public static int Solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        if (matrix[0][0] == 9) return 1;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0,0});
        matrix[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == 1) continue;
                if (matrix[x][y] == 9) return 1;
                queue.offer(new int[]{x, y});
                matrix[x][y] = 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {0,0,1,0},
            {0,0,1,1},
            {1,0,0,0},
            {1,1,1,0}
        };
        System.out.print(Maze.Solution(matrix));
    }
}