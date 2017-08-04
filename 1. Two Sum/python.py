class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        dic = {}
        
        for i in range(len(nums)):
            if target-nums[i] in dic:
                a = dic[target - nums[i]]
                b = i
                return[a, b]
            dic[nums[i]] = i
        return []