public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j != 0) continue;
                int count = 1 + (i - j) / j;
                if (dp[i] == 0 || dp[i] > count + dp[j]) {
                    dp[i] = count + dp[j];
                }
            }
        }
        return dp[n];
    }
}