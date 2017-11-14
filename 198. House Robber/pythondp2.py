class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        pre = cur = 0
        for i in range(len(nums)):
            temp = max(pre + nums[i], cur)
            pre = cur
            cur = temp
        return cur
        