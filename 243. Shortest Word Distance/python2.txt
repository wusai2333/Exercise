lass Solution(object):
    def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        """
        prev, minDist = -1, len(words)
        for i in xrange(len(words)):
            if words[i] in (word1, word2):
                if prev != -1 and words[i] != words[prev]:
                    minDist = min(minDist, i - prev)
                prev = i
        return minDist
        """
        p1, p2, minDist = -1, -1, len(words)
        for i , w in enumerate(words):
            if w == word1:
                p1 = i
                
            elif w == word2:
                p2 = i
            if( p1 != -1 and p2 != -1):
                minDist = min (abs(p2 - p1), minDist)
        return minDist
                