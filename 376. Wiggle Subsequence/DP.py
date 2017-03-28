class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        f = [1] * n
        d = [1] * n
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[i - 1]:
                    f[i] = max(f[i], d[j] + 1)
                elif nums[i] < nums[i - 1]:
                    d[i] = max(d[i], f[j] + 1)
        return max(d[-1], f[-1])
