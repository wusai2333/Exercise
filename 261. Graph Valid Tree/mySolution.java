public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) return true;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] edge: edges) {
            int rootX = find(roots, edge[0]);
            int rootY = find(roots, edge[1]);

            if (rootX == rootY) return false;

            roots[rootX] = rootY;
        }

        return edges.length == n - 1;
    }

    private int find(int[] roots, int i) {
        while (i != roots[i]) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}