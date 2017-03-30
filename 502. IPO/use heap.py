class Solution(object):
    def findMaximizedCapital(self, k, W, Profits, Capital):
        """
        :type k: int
        :type W: int
        :type Profits: List[int]
        :type Capital: List[int]
        :rtype: int
        """
        pq = []
        pair = sorted(zip(Capital, Profits), key=lambda (c, p): (c, -p))
        print pair
        for _ in range(k):
            while pair and pair[0][0] <= W:
                heapq.heappush(pq, -pair.pop(0)[1])
            if pq:
                W -= heapq.heappop(pq)
        return W
