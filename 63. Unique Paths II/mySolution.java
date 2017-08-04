
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            dp[i][0] = 1;
            if (obstacleGrid[i][0] == 1) dp[i][0] = 0;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            dp[0][i] = 1;
            if (obstacleGrid[0][i] == 1) dp[0][i] = 0;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}