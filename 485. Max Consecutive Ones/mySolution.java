public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int num: nums) {
            if (num == 1) {
                cur ++;
                max = Math.max(cur, max);
            } else {
                cur = 0;
            }
        }
        return max;
    }
}