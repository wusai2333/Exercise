class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if not p: return not s

        if len(p)>1 and p[1] == '*':
            return self.isMatch(s, p[2:]) or len(s)>0 and (s[0] == p[0] or p[0] == '.') and self.isMatch(s[1:], p)
        else:
            return len(s)>0 and (s[0] == p[0] or p[0] == '.') and self.isMatch(s[1:], p[1:])