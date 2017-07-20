# just randomized the input and we can get the the O(n) time guranteed.
import  random
def findKthLargest(self, nums, k):
    random.shuffle(nums)
    k = len(nums) - k
    lo, hi = 0, len(nums)-1
    while lo < hi:
        j = self.partition(nums, lo, hi)
        if j < k:
            lo = j + 1
        elif j > k:
            hi = j - 1
        else:
            break;
    return nums[k]

def partition(self, nums, lo, hi):
    i, j = lo, hi
    while True:
        i += 1
        while i < hi and nums[i] < nums[lo]:
            i += 1
        j -= 1
        while j > lo and nums[lo] < nums[j]:
            j -= 1
        if (i >= j):
            break
        self.swap(nums, i, j)
    
    self.swap(nums, lo, j)
    return j

def swap(self, nums, i, j):
    nums[i], nums[j] = nums[j], nums[i]