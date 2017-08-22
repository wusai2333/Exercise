class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        self.maxlen, self.lo = 0, 0
        if len(s) < 2: return s
        
        def extendPalindrome(s, j ,k):
            while j >= 0 and k < len(s) and s[j] == s[k]:
                j -= 1
                k += 1
            if self.maxlen <= k - j - 1:
                self.lo = j + 1
                self.maxlen = k - j - 1
                
        for i in range(len(s)-1):
            extendPalindrome(s, i, i) #odd length , extend palindrome as long as possible
            if s[i] == s[i + 1]:
                extendPalindrome(s, i, i+1) # even length, same as above
        return s[self.lo: self.lo + self.maxlen]
            
            
        
        
            