class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        /**
         * find the index of the smallest value using binary search.
         * Loop will terminate since mid < hi, and lo or hi will shrink by at least 1
         * Proof by contradictiont that
         */
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int offset = lo;
        int n = nums.length;
        lo = 0; hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int realMid = (mid + offset) % n;
            if (nums[realMid] == target) return realMid;
            if (nums[realMid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}