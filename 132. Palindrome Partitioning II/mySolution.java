class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] pal = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || pal[j+1][i-1])) {
                    pal[j][i] = true;
                    if (j == 0)
                        dp[i] = 0;
                    else if (dp[j-1] + 1 < dp[i]) {
                        dp[i] = dp[j-1] + 1;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }

}
