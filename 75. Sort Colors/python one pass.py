class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        red, blue = 0 , len(nums)-1
        for i in range(len(nums)):
            while nums[i] == 2 and i < blue: 
                nums[i], nums[blue] = nums[blue], nums[i]
                blue -= 1
            while nums[i] == 0 and i > red:
                nums[i], nums[red] = nums[red], nums[i]
                red += 1
            
swap all 0 to the left side and all 2 to the right side and finally 1 will be in the middle
