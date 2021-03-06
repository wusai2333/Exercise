class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #if len(nums)<2: return len(nums)
        #idx = 1
        idx = 1 if len(nums)>0 else 0
        for i in range(1,len(nums)):
            if nums[i] != nums[i-1]:
                nums[idx] = nums[i]
                idx += 1
        return idx
