class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = nums.length() - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) return new int[]{start, end};
            while (start < end && nums[start+1] == nums[start]) start ++;
            while (start < end && nums[end-1] == nums[end]) end--;
            if (nums[start] + nums[end] < target) start++;
            else end--;
        }
        return new int[]{start, end};
    }
}