import java.util.ArrayList;

public class Solution {
    private static final int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }
        // int[][] matrix = new int[m][n];
        // for (int[] pos: positions) {
        //     matrix[pos[0]][pos[1]] = 1;
        // }

        // UnionFind
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        int count = 0;
        for (int[] p: positions) {
            int root = n * p[0] + p[1];
            roots[root] = root; // add new island
            count ++;

            for (int[] dir: dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = n * x + y; // neighbor
                if (x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;
                int rootNb = findIsland(roots, nb); // find the neighbor's root
                if (root != rootNb) { // if neighbor is in another island
                    roots[root] = rootNb;
                    root = rootNb;
                    count--;
                }
            }

            result.add(count);
        }
        return result;
    }

    public int findIsland(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}