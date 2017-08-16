public class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, edges, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, int[][] edges, boolean[] visited) {
        for (int[] edge: edges) {
            int n = edge[0], m = edge[1];
            if (n == i && visited[m] == false || m == i && visited[n] == false) {
                int next = (m == i) ? n : m;
                visited[next] = true;
                dfs(next, edges, visited);
            }
        }
    }
}