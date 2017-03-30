class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        stk = []
        for i in num:
            while stk and k > 0 and stk[-1] > i:
                stk.pop()
                k -= 1
            stk.append(i)
        return ''.join(stk[:-k or None]).lstrip('0') or '0'
