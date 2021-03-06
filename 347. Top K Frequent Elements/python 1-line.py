class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        # use Counter to extract the top k elements
        # most_common(k) return a list of tuples, where the first item of the tuple is the element, and the second items of tuple is the count
        # zip function could be used to extract the first item of the tuples
        return zip(*collections.Counter(nums).most_common(k))[0]