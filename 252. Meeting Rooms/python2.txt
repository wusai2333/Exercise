class Solution(object):
    def canAttendMeetings(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: bool
        """
        intervals.sort(key=lambda i: i.start)
        '''return all(intervals[i-1].end <= intervals[i].start 
                        for i in range (1, len(intervals)))
	'''
 	return all (i.end < j.start for i, j in zip(intervals, intervals[1:]))