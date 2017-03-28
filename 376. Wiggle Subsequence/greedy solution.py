class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return len(nums)
        k = 0
        # skip all numbers from the series beginning
        while k < len(nums) - 1 and nums[k] == nums[k + 1]:
            k += 1
        if k == len(nums) - 1:
            return 1

        result = 2  # this will track the result of result array
        smallReq = nums[k] < nums[k + 1]  # To check the staring pattern
        nums[0], nums[1] = nums[k], nums[k + 1]
        for i in range(k + 1, len(nums) - 1):
            if smallReq and nums[i] > nums[i + 1]:
                nums[result] = nums[i + 1]
                result += 1
                smallReq = not smallReq
            elif not smallReq and nums[i] < nums[i + 1]:
                nums[result] = nums[i + 1]:
                result += 1
                smallReq = not smallReq
        return result
