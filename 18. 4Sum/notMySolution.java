import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        int len = nums.length;

        Arrays.sort(nums);
        int max = nums[len-1];
        if (4 * max < target || 4 * nums[0] > target) return res;
        int i, z;
        for (i = 0; i < nums.length; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1]) continue;
            if (z + 3 * max < target) continue; // z is too small;
            if (4 * z == target) {
                if (i + 3 < len && nums[i + 3] == z) { 
                    res.add(Arrays.asList(z, z, z, z));
                    break;
                }
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }
        return res;
    }

    private void threeSumForFourSum(int[] nums, int target, int start, int end, List<List<Integer>> res, int z1) {
        if (start + 1 >= end) return;

        int max = nums[end];
        if (3 * max < target || 3 * nums[start] > target) return;
        
        int i, z;
        for (i = start; i < end-1; i++) {
            z = nums[i];
            if (i > start && z == nums[i - 1]) continue;
            if (z + 2 * max < target) continue;
            if (3 * z == target) {
                if (i + 2 <= end && z == nums[i + 2]) {
                    res.add(Arrays.asList(z1, z, z, z));
                    break;
                }
            }

            twoSumForThreeSum(nums, target - z, i + 1, end, res, z, z1);
        }
    }

    private void twoSumForThreeSum(int[] nums, int target, int start, int end, List<List<Integer>> res, int z2, int z1) {
        if (start >= end) return;
        
        if (2 * nums[end] < target || 2 * nums[start] > target) return;
        
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                res.add(Arrays.asList(z1, z2, nums[start], nums[end]));
                while (start < end && nums[start + 1] == nums[start]) start++;
                while (start < end && nums[end - 1] == nums[end]) end--;
                start++; end--;
                if (start >= end) return;
            }
            if (nums[start] + nums[end] < target) start++;
            else if (nums[start] + nums[end] > target) end--;
        }
    }
}