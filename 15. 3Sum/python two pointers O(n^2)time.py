class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res, n = [], len(nums)
        for i in range(n-2):
            if i == 0 or i >0 and nums[i]!=nums[i-1]:
                start, end, sum = i + 1, n - 1, -nums[i]
                while start < end:
                    if nums[start] + nums[end] == sum: 
                        res.append([nums[i], nums[start], nums[end]])
                        while start < end and nums[start + 1] == nums[start]: start += 1
                        while start < end and nums[end] == nums[end-1]: end -= 1
                        start += 1
                        end -= 1
                    elif nums[start] + nums[end] < sum: start += 1
                    else: end -= 1
        return res