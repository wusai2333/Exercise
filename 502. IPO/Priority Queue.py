import Queue


class Solution(object):
    def findMaximizedCapital(self, k, W, Profits, Capital):
        """
        :type k: int
        :type W: int
        :type Profits: List[int]
        :type Capital: List[int]
        :rtype: int
        """
        pq = Queue.PriorityQueue()
        pairs = sorted(zip(Capital, Profits))[::-1]
        for _ in range(k):
            while pairs and pairs[-1][0] <= W:
                pq.put((-pairs[-1][0], pairs.pop()[1]))
            if not pq.empty():
                W += pq.get()[1]
            else:
                break
        return W
