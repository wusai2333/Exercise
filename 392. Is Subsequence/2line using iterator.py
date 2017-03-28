def isSubsequence(s, t):
    """
    :type s: str
    :type t: str
    :rtype: bool
    """
    t = iter(t)
    return all(c in t for c in s)


print(isSubsequence('china', 'china'))

# For the follow-up question, however, this solution is not efficient as we need to compare s with t every time. For example, if we have k=1B, len(s) = 100, len(t)=500,000, the total complexity will be O(10^9*(100+500,000)). So the tricky is we don't want to scan t every time as it costs too much.
#
# Here is solution 2, check comments for a brief explanation. The idea is to scan t once and save the index (as a sorted list) of each letter.
#
# The running time is 525 ms. Although this one-time run cost of solution
# 2 is bigger than solution 1, if we have many s, we can save a lot of
# time by avoid comparing s with t every time.


class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        idx = -1
        try:
            for c in s:
                idx = t.index(c, idx + 1)
            return True
        except ValueError:
            return False

    def isSubsequence(self, s, t):
        # create a list to save the index of each letter in t
        listt = [[] for _ in range(26)]

        for i in range(len(t)):
            listt[ord(t[i]) - 97].append(i)
        # create a list to find the index of each letter of s in t
        lists = [0 for _ in range(len(s))]

        if not s:
            return True
        if not listt[ord(s[0]) - 97]:
            return False  # if first letter of s is not in t
        lists[0] = listt[ord(s[0]) - 97].pop(0)  # min. value for first letter

        for i in range(1, len(s)):
            if not listt[ord(s[i]) - 97]:
                return False  # if the letter is not in t
            index, value = self.helper(listt[ord(s[i]) - 97], lists[i - 1])
            if index == -1:
                return False
            lists[i], listt[ord(s[i]) - 97] = value, listt[ord(s[i]) - 97][index + 1:]

        return lists == sorted(lists)
      # a helper function to find the index

    def helper(self, nums, value):
        if value > nums[-1]:
            return (-1, -1)
        else:
            temp, i = nums[0], 0
            while value > temp and i < len(nums):
                i += 1
                temp = nums[i]
        return (i, temp)
