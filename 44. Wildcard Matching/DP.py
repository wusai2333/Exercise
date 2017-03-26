def isMatch(self, s, p):
    """
    :type s: str
    :type p: str
    :rtype: bool
    """
    if len(p) - p.count('*') > len(s):
        return False
    dp = [True] + [False] * len(s)
    for j in p:
        if j != '*':
            for n in reversed[range(len(s))]:
                dp[n + 1] = dp[n] and (j == s[n] or j == '?')
        else:
            for n in range(len(s)):
                dp[n + 1] = dp[n] or dp[n + 1]
        dp[0] = dp[0] and j == '*'
    return dp[len(s)]
