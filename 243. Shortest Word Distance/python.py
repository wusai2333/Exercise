class Solution(object):
    def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        prev, minDist = -1, len(words)
        for i in xrange(len(words)):
            if words[i] in (word1, word2):
                if prev != -1 and words[i] != words[prev]:
                    minDist = min(minDist, i - prev)
                prev = i
        return minDist