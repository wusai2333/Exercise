<<<<<<< HEAD
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        try{ Arrays.sort(intervals, new IntervalComparator());
        } catch (Exception e) {
            return false;
        }
        return true;
    }   
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval o1, Interval o2) {
            if (o1.start < o2.start && o1.end <=o2.start)
                return -1;
            else if (o1.start > o2.start && o1.start >= o2.end)
                return 1;
            throw new RuntimeException();
        }
    }
=======
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        try{ Arrays.sort(intervals, new IntervalComparator());
        } catch (Exception e) {
            return false;
        }
        return true;
    }   
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval o1, Interval o2) {
            if (o1.start < o2.start && o1.end <=o2.start)
                return -1;
            else if (o1.start > o2.start && o1.start >= o2.end)
                return 1;
            throw new RuntimeException();
        }
    }
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
}