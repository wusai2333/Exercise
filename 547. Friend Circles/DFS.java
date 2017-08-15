public class Solution {
    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j ++) {
            if (M[i][j] == 1 && visited[i] = false) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == false) {
                dfs(M, visited, i);
                count ++;
            }
        }
        return count;
    }
}