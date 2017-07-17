class Solution(object):
    def subsets(self, nums):
        ans = []
        self._backtrack(ans, [], nums, 0)
        return ans
    def _backtrack(self, ans, templist, nums, start):
        ans.append(templist[:]) # a new list, a copy of templist(important)
        for i in range(start, len(nums)):
            templist.append(nums[i])
            self._backtrack(ans, templist, nums, i+1)
            templist.pop()
