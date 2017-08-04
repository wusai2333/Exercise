public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] a = new int[length];
        for (int[] update: updates) {
            int start = update[0];
            int end = update[1];
            int incr = update[2];
            for (int i = start; i <= end; i ++) {
                a[i] += incr;
            }
        }
        return a;
    }
}