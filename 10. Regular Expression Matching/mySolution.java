/**
 * if s.chatAt(i) == p.chatAt(j) dp[i][j] = dp[i-1][j-1];
 * else if p.charAt(j) == '.' dp[i][j] = dp[i-1][j-1];
 * else if p.charAt(j) == '*':
 *      1. if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]; // a* count as empty;
 *      2. if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
 *          dp[i][j] = dp[i-1][j]  // a* count as multiple a;
 *                    || dp[i][j-1] // a* count as single a;
 *                    || dp[i][j-2] // a* count as empty;
 */
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1])
                dp[0][i+1] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) 
                    dp[i+1][j+1] = dp[i][j];
                else if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                else if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}