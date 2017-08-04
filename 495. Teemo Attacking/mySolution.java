public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            sum += Math.min(duration, timeSeries[i+1] - timeSeries[i]);
        }
        sum += duration;
        return sum;
    }
}