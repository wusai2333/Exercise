public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, begin = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[n-1-i]);
            max = Math.max(max, nums[i]);
            if (nums[i] < max) end = i;
            if (nums[n-1-i] > min) begin = n-1-i;
        }
        return end - begin + 1;
    }
}