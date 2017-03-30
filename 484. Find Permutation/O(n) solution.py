# For example, given IDIIDD we start with sorted sequence 1234567
# Then for each k continuous D starting at index i we need to reverse [i,
# i+k] portion of the sorted sequence.


class Solution(object):
    def findPermutation(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        def reverse(arr, l, h):
            while l < h:
                arr[l], arr[h] = arr[h], arr[l]
                l += 1
                h += 1

        arr = list(range(1, len(s) + 2))
        h = 0
        while h < len(s):
            if s[h] == 'D':
                l = h
                while h < len(s) and s[h] == 'D':
                    h += 1
                reverse(arr, l, h)  # list is mutable, integer is immutable
            h += 1
        return arr
