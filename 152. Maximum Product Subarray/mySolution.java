class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int imax = nums[0];
        int imin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) imax = exch(imin, imin = imax);
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            res = Math.max(res, imax);
        }
        
        return res;
    }

    private int exch(int itself, int dummy) {
        return itself;
    }
}