<<<<<<< HEAD
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) < 2: return s
        minstart, maxlen = 0, 1
        for i in range(len(s) - 1):
            if len(s) - i <= maxlen / 2: break
            j, k = i, i
            while k < len(s)-1 and s[k + 1] == s[k]: k += 1 # skip the duplicate
            while j > 0 and k < len(s)-1 and s[j - 1] == s[k + 1]:
                k += 1
                j -= 1
            if k - j + 1 > maxlen:
                minstart = j
                maxlen = k - j + 1
=======
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) < 2: return s
        minstart, maxlen = 0, 1
        for i in range(len(s) - 1):
            if len(s) - i <= maxlen / 2: break
            j, k = i, i
            while k < len(s)-1 and s[k + 1] == s[k]: k += 1 # skip the duplicate
            while j > 0 and k < len(s)-1 and s[j - 1] == s[k + 1]:
                k += 1
                j -= 1
            if k - j + 1 > maxlen:
                minstart = j
                maxlen = k - j + 1
>>>>>>> origin/master
        return s[minstart: minstart + maxlen]