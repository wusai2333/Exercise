// Follow up the HIndex;
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n, mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (citations[mid] == n - mid) return citations[mid];
            else if (citations[mid] > n - mid) right = mid;
            else left = mid + 1;
        }
        return n - left;
    }
}