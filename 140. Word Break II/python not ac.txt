<<<<<<< HEAD
class Solution(object):
    mem = {}
    def _combine(self, word, prev):
        for i in range(len(prev)):
            prev[i] += " " + word
        return prev
        
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        result = []
        if s in self.mem: return self.mem[s]
        if s in wordDict: # if s is a word
            result.append(s)
        for i in range(len(s)):
            word = s[i:]
            if word in wordDict:
                rem = s[:i]
                prev = self._combine(word, self.wordBreak(rem, wordDict))
                result += prev
        self.mem[s] = result 
        return result
            
=======
class Solution(object):
    mem = {}
    def _combine(self, word, prev):
        for i in range(len(prev)):
            prev[i] += " " + word
        return prev
        
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        result = []
        if s in self.mem: return self.mem[s]
        if s in wordDict: # if s is a word
            result.append(s)
        for i in range(len(s)):
            word = s[i:]
            if word in wordDict:
                rem = s[:i]
                prev = self._combine(word, self.wordBreak(rem, wordDict))
                result += prev
        self.mem[s] = result 
        return result
            
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
            