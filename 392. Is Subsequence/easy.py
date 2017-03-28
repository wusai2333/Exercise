class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        for c in s:
            if c in t:
                t = t[t.find(c) + 1:]
            else:
                return False
        return True
