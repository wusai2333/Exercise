public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        int m = nums.length;
        int n = nums[0].length;
        if (r*c != m*n) return nums;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                res[((i*n)+j)/c][((i*n)+j)%c] = nums[i][j];
            }
        }
        /**
         * for (int i = 0; i < r * c; i++) {
         *      res[i/c][i%c] = nums[i][j];
         * }
         */
        return res;
    }
}