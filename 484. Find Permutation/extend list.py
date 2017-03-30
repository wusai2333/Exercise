class Solution(object):
    def findPermutation(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        res = []
        for i in range(len(s)):
            if s[i] == 'I':
                res.extend(range(i + 1, len(res), -1)
        res.extend(len(s) + 2, len(res), -1)
        return res
