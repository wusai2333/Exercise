class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) /2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] == nums[end]) {
                if (nums[end - 1] > nums[end]) return nums[end];
                end--;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}