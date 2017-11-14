import java.util.Arrays;
import java.util.Comparator;
class Interval {
    int start;
    int end;
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
class Solution {
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public boolean canAttendMeetings (Intervals[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new IntervalComparator());
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start) return false;
        }
        return true;
    }
}