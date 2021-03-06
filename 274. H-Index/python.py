class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        if n == 0: return 0
        
        count = [0] * (n+1)
        for i in range(n):
            if citations[i] > n:
                count[n] += 1
            else:
                count[citations[i]] += 1
        t = 0
        for i in range(n, -1, -1):
            t += count[i]
            if t >= i:
                return i
        return 0
    
# We first create a new vector counts of size L+1 where L is the length of the citations vector. The counts vector stores the number of papers having a citation equal to its index for i=0 to L-1. For i=L, it stores the number of papers having a citation equal to or greater than L. A simple fact is that the h-index can be at most L, this happens when all of his papers have citations no less than L. Therefore, for the purpose of computing h-index, if a person has L papers, it would end up with the same h-index no matter one of his paper has a citation of 10L or L.

# After finalizing the counts vector, we can then easily locate his h-index by scanning from right (L) to left (0). By definition, index k is his h-index if the summation of all elements from counts[k] to counts[L] is no less than k.