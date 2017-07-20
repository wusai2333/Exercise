from heapq import *
def findKthLargest(self, nums, k):
    heapify(nums)
    return nlargest(k, nums)[-1]