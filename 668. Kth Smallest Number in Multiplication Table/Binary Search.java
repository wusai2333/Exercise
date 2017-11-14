class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int c = count(mid, m, n);
            if (c >= k) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }

    private int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i, n);
            count += temp;
        }
        return count;
    }
}