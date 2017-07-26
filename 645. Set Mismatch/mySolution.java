import java.util.HashSet;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        HashSet<Integer> set = new HashSet<>();
        int dup =  0;
        for (int i = 0; i < nums.length; i ++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                dup = nums[i];
            }
        }
        int lost = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                lost = i;
            }
        }
        return new int[]{dup, lost};
    }
}