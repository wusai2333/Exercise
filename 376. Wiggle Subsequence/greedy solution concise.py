class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n, f, d = len(nums), 1, 1
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                f = d + 1
            elif nums[i] < nums[i - 1]:
                d = f + 1
        return min(n, max(f, d))
