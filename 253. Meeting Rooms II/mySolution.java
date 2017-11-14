class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare (Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare (Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            
            if (interval.end <= intervals[i].start) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    class IntervalComparator implements Comparator<Interval> {
        public int compare (Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare (Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        
        Arrays.sort(intervals, new IntervalComparator());
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            
            if (interval.end <= intervals[i].start) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }
}