// Same techniques is used in leetcode 354, 
// O(nlogn) time.
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int size = 0;
        int len = nums.length;
        int[] minTail = new int[len];
        for (int num : nums) {
            int start = 0, end = size;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (minTail[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            minTail[start] = num;
            if (start == size) size++;
        }
        return size;
    }
}