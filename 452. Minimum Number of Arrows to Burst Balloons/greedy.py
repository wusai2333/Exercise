# Sort intervals by ending value;
# Only count valid intervals we need, and skip overlapping intervals
#  return the count


class Solution(object):
    def findMinArrowShots(self, points):
        points.sort(key=lambda x: x[1])
        res, end = 0, -float('inf')
        for interval in points:
            if interval[0] > end:
                res += 1
                end = interval[1]
        return res
