class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        int prev = 0, cur = 0;
        for (int num : nums) {
            int temp = cur;
            cur = Math.max(num + prev, cur);
            prev = temp;
        }
        return cur;
    }
}