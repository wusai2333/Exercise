/*Actually, the problem is the same as "Given a collection of intervals, find the maximum number of intervals that are non-overlapping." (the classic Greedy problem: Interval Scheduling). With the solution to that problem, guess how do we get the minimum number of intervals to remove? : )
 *
 * Sorting Interval.end in ascending order is O(nlogn), then traverse intervals array to get the maximum number of non-overlapping intervals is O(n). Total is O(nlogn).*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.Arrays;
public class Solution {
	public int eraseOverlapIntervals(Interval[] intervals)
	{
		if (intervals.length == 0) { return (0); }

		Arrays.sort(intervals, new Comparator<Interval>()
		{
			public int compare(Interval a, Interval b)
			{
				return (a.end - b.end);
			}
		});

		int end = intervals[0].end;
		int count = 1;
		for (int i = 1; i < intervals.length; i++)
		{
			if (intervals[i].start >= end) {
				end = intervals[i].end
				    count++;
			}
		}
		return (intervals.length - count);
	}
}
