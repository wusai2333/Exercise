import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i < len - 1; i ++) {
            int left = i - 1, right = len - 1;
            while (left >= 0 && right > i) {
                if (nums[left] + nums[i] > nums[right]) {
                    count += right - i;
                    left --;
                } else {
                    right --;
                }
            }
        }
        return count;
    }
}