import java.util.ArrayList;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // create adjList;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // add Edges;
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];

        // make sure there is no cycle:
        if (hasCycle(adjList, 0, visited, -1)) {
            return false;
        }

        // make sure it is connected:
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;
        for(int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);
            if ((visited[v] && parent != v) || (! visited[v] && hasCycle(adjList, v, visited, u))) {
                return true;
            }
        }
        return false;
    }
}