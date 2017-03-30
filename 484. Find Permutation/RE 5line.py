import re


class Solution(object):
    def findPermutation(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        arr = range(1, len(s) + 2)
        for m in re.finditer('D+', s):
            i, j = m.start(), m.end() + 1
            arr[i: j] = arr[i: j][::-1]
        return arr
