<<<<<<< HEAD
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxherepre = nums[0]
        minherepre = nums[0]
        maxsofar = nums[0]
        
        for num in nums[1:]:
            maxhere = max(max(maxherepre * num, minherepre * num), num)
            minhere = min(min(minherepre * num, maxherepre * num), num)
            maxsofar = max(maxhere, minhere, maxsofar)
            maxherepre = maxhere
            minherepre = minhere
            
        return maxsofar
=======
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxherepre = nums[0]
        minherepre = nums[0]
        maxsofar = nums[0]
        
        for num in nums[1:]:
            maxhere = max(max(maxherepre * num, minherepre * num), num)
            minhere = min(min(minherepre * num, maxherepre * num), num)
            maxsofar = max(maxhere, minhere, maxsofar)
            maxherepre = maxhere
            minherepre = minhere
            
        return maxsofar
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
        