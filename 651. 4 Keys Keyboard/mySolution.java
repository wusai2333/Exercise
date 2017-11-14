class Solution {
    public int maxA(int N) {
        int[] dp = new int[N+1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
               if (i - j >= 3) {
                   int count1 = i - j;
                   int count2 = (i - j - 2) * dp[j];
                   int count = Math.max(count1, count2);
                   dp[i] = Math.max(dp[i], dp[j] + count);
               } else {
                   dp[i] = Math.max(dp[i], dp[j] + i - j);
               }
            }
        }
        return dp[N];
    }
}