class Solution(object)
    def strStr(self, haystack, needle)
        
        type haystack str
        type needle str
        rtype int
        
        m, n = len(haystack), len(needle)
        for i in range (m - n + 1)
            j = 0
            while j  n
                if haystack[i+j] != needle[j]
                    break
                j += 1
            if j == n return i
        return -1
            