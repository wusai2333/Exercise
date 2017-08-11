public class Solution {
    public void sortColors(int[] nums) {
        int n0 = -1, n1 = -1, n2 = -1;
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            if (nums[i] == 0) {
                nums[++n2] = 2; nums[++n1] = 1; nums[++n0] = 0;
            }
            else if (nums[i] == 1) {
                nums[++n2] = 2; nums[++n1] = 1;
            }
            else if (nums[i] == 2) {
                nums[++n2] = 2;
            }
        }
    }
}