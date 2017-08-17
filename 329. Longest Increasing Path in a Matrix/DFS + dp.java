

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = findSmallAround(matrix, i, j, dp, Integer.MIN_VALUE);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int findSmallAround(int[][] matrix, int i, int j, int[][] dp, int pre) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        } else {
            int cur = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(findSmallAround(matrix, i-1, j, dp, cur), tempMax);
            tempMax = Math.max(findSmallAround(matrix, i+1, j, dp, cur), tempMax);
            tempMax = Math.max(findSmallAround(matrix, i, j-1, dp, cur), tempMax);
            tempMax = Math.max(findSmallAround(matrix, i, j+1, dp, cur), tempMax);
            dp[i][j] = ++tempMax;
            return tempMax;
        }
    }
}