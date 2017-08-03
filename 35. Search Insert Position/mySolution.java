public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] > target) right = mid;
            else if (nums[mid] == target) return mid;
            else left = mid + 1;
        }
        return left;
    }
}