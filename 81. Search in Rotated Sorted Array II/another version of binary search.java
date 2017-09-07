class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) {hi--;lo++;}
            else if (nums[mid] <= nums[hi]) {
                if (nums[mid] < target && nums[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            } else if (nums[mid] >= nums[lo]) {
                if (nums[mid] > target && nums[lo] <= target) hi = mid - 1;
                else lo = mid + 1;
            }
        }
        return false;
    }
}