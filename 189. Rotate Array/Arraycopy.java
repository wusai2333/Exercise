public class Solution {
    public void rotate(int[] nums, int k) {
        int[] numscopy = new int[nums.length];
        k = k > nums.length ? k % nums.length: k;
        for (int i = 0; i < nums.length; i++) {
            numscopy[i] = nums[(i + nums.length - k)%nums.length];
        }
        System.arraycopy(numscopy, 0, nums, 0, nums.length);
    }
}