<<<<<<< HEAD
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        insertPos = 0
        for i in xrange(len(nums)):
            if nums[i]:
                nums[insertPos] = nums[i]
                insertPos += 1
        for i in xrange(insertPos, len(nums)):
=======
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        insertPos = 0
        for i in xrange(len(nums)):
            if nums[i]:
                nums[insertPos] = nums[i]
                insertPos += 1
        for i in xrange(insertPos, len(nums)):
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
            nums[i] = 0