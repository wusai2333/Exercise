class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        i, j, ss, star = 0, 0, 0, -1
        n, m = len(s), len(p)

        while i < n:
            if j < m and (p[j] == s[i] or p[j] == '?'):
                i += 1
                j += 1
            elif j < m and p[j] == '*':
                star = j
                j += 1
                ss = i
            elif star >= 0:
                j = star + 1
                ss += 1
                i = ss
            else:
                return False
        while j < m and p[j] == '*':
            j += 1
        return j == m
