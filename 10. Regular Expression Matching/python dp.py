class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if not p: return not s
        dp = [[False]*(len(p)+1) for _ in range(len(s) + 1)]
        dp[0][0] = True
        
        for i in range(len(p)):
            if p[i] == '*' and dp[0][i-1]:
                dp[0][i+1] = True
                
        for i in range(len(s)):
            for j in range(len(p)):
                if p[j] == '.':
                    dp[i+1][j+1] = dp[i][j]
                if p[j] == s[i]:
                    dp[i+1][j+1] = dp[i][j]
                if p[j] == '*':
                    if p[j-1] != s[i] and p[j-1] != '.':
                        dp[i+1][j+1] = dp[i+1][j-1]
                    else:
                        dp[i+1][j+1] = (dp[i][j+1] or dp[i+1][j] or dp[i+1][j-1])
        return dp[-1][-1]



1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty