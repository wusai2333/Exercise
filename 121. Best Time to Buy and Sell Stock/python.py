class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxcur, maxsofar = 0, 0
        for i in range(0, len(prices)):
            maxcur += prices[i] - prices[i-1]
            maxcur = max(maxcur, 0)
            maxsofar = max(maxsofar, maxcur)
        return maxsofar