public class DFSMaximumMinimumPath {
    private static int min, max, m, n;
    public static int solution(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(matrix, min, 0, 0);
        return max;
    }

    private static void dfs(int[][] matrix, int min, int i, int j) {
        if (i >= m || j >= n) return;
        if (i == m - 1 && j == n - 1) {
            min = Math.min(min, matrix[i][j]);
            max = Math.max(max, min);
        }
        min = Math.min(min, matrix[i][j]);
        dfs(matrix, min, i + 1, j);
        dfs(matrix, min, i, j + 1);
    }

    public static int minMaxPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs2(matrix, min, 0, 0);
        return max;
    }

    private static void dfs2(int[][] matrix, int min, int i, int j) {
        if (i >= m || j >= m) return;
        if (i == m - 1 && j == n - 1) {
            min = Math.min(min, matrix[i][j]);
            max = Math.max(max, min);
            return;
        }
        min = Math.min(min, matrix[i][j]);
        dfs(matrix, min, i + 1, j);
        dfs(matrix, min, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {8, 4, 7},
            {6, 5, 9}
        };
        // DFSMaximumMinimumPath DFS = new DFSMaximumMinimumPath();
        System.out.println(DFSMaximumMinimumPath.solution(matrix));
        System.out.print(DFSMaximumMinimumPath.minMaxPath(matrix));
    }   
}