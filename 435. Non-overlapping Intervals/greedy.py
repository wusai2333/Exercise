# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e


class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        end = float('-inf')
        erased = 0
        for i in sorted(intervals, key=lambda x: x.end):
            if i.start >= end:
                end = i.end
            else:
                erased += 1
        return erased
