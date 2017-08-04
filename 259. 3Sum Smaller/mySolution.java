import java.util.Arrays;

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len;i++ ) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    count += right - left;
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return count;
    }
}