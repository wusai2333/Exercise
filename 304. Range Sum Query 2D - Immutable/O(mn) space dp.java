import java.util.Arrays;

class NumMatrix {
        int[][] tree;
        int[][] nums;
        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            int m = matrix.length, n = matrix[0].length;
            tree = new int[m+1][n+1];
            nums = new int[m+1][n+1];
            for (int i = 0; i < m; i++) {
                nums[i] = Arrays.copyOf(matrix[i], n);
                for (int j = 0; j < n; j++) {
                    updateTree(i, j, matrix[i][j]);
                }
            }
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getSum(row2+1, col2 +1) - getSum(row1, col2+1) - getSum(row2+1, col1) + getSum(row1, col1);
        }

        public void update(int row, int col, int val) {
            updateTree(row, col, val - nums[row][col]);
            nums[row][col] = val;
        }

        private void updateTree(int i, int j, int val) {
            for (int r = i+1; r < tree.length; r += lastOneBit(r)) {
                for (int c = j+1; c < tree[0].length; c += lastOneBit(c)) {
                    tree[r][c] += val;
                }
            }
        }
        public int getSum(int row, int col) {
            int sum = 0;
            for (int i = row; i > 0; i -= lastOneBit(i)) {
                for (int j = col; j > 0; j -= lastOneBit(j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }

        private int lastOneBit(int i) {
            return i & (-i);
        }
    }
    
    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */