public class Solution {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length+2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] memo = new int[n][n];
        return burst(nums, memo, 0, n-1);
    }

    public int burst(int[] nums, int[][] memo, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left+1; i < right; i++) {
            ans = Math.max(ans, nums[left]*nums[i]*nums[right] + burst(nums, memo, left, i) + burst(nums, memo, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}