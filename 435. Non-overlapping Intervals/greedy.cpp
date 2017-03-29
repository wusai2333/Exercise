/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
	int eraseOverlapIntervals(vector<Interval>& intervals)
	{
		if (intervals.size() == 0) { return (0); }
		sort(intervals.begin(), intervals.end(), mysort);

		int end = intervals[0].end;
		int erased = 0;
		for (int i = 1; i < intervals.size(); i++)
		{
			if (intervals[i].start >= end) {
				end = intervals[i].end;
			} else {
				erased++;
			}
		}
		return (erased);
	}


	static bool mysort(Interval& a, Interval& b)
	{
		return (a.end < b.end);
	}
}
