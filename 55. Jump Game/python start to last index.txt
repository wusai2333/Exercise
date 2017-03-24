<<<<<<< HEAD
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        pos, reach = 0, 0
        while pos < len(nums) and pos <= reach:
            reach = max(nums[pos] + pos, reach)
            pos += 1
            
        return reach >= len(nums)-1
=======
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        pos, reach = 0, 0
        while pos < len(nums) and pos <= reach:
            reach = max(nums[pos] + pos, reach)
            pos += 1
            
        return reach >= len(nums)-1
>>>>>>> origin/master
            