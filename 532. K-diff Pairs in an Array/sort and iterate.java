public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums.length == 0 || nums == null) return 0;
        Arrays.sort(nums);
        int count = 0;
        int i = 0, j = 1;
        while (i < nums.length) {
            j = Math.max(i+1, j);
            while(j < nums.length && nums[j] - nums[i] < k) {
                j ++;
            }
            if (j < nums.length && nums[j] - nums[i] == k) {
                count ++;
            }
            while (i+1 < nums.length && nums[i+1] == nums[i]) {
                i++;
            }
            i++;
        }
        return count;
    }
}