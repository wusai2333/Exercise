import java.util.Arrays;

public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] > mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}