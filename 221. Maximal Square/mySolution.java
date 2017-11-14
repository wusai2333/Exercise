/**
 * if matrix[i][j] == 1, dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
 * if matrix[i][j] == 0, dp[i][j] = 0;
 */
/**
 * O(n^2) space
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i]-'0';
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0]-'0';
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
/**
 * O(n) space
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            row[i] = matrix[0][i] - '0';
            max = Math.max(max, row[i]);
        }
        for (int i = 1; i < m; i++) {
            int[] tmp = new int[n];
            tmp[0] = matrix[i][0] - '0';
            max = Math.max(max, tmp[0]);
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    tmp[j] = Math.min(tmp[j-1], Math.min(row[j-1], row[j])) + 1;
                    max = Math.max(tmp[j], max);
                } else {
                    tmp[j] = 0;
                }
            }
            row = tmp;
        }
        return max * max;
    }
}