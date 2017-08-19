public class Solution {
    class UnionFind {
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[p] < rank[q]) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
                if (rank[p] == rank[q])
                    rank[q] ++;
            }
            count --;
        }

        public int count() {
            return count;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }

    private static final int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) 
            return;
        int m = board.length, n = board[0].length;
        UnionFind uf = new UnionFind(m*n + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j] == 'O') // if 'O' node is on the boundary, connect it to the dummy node;
                    uf.union(i*n + j, m*n);
                else if (board[i][j]=='O') { // connect a 'O' node its neighbor 'O' nodes
                    for (int[] dir: dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (board[x][y] == 'O')
                            uf.union(x*n+y, i*n+j);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!uf.connected(i*n+j, m*n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}