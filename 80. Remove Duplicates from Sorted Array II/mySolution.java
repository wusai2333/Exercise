class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int index = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 1;
                nums[index++] = nums[i];
            } else if (count < 2) { // k = 2, you can change the k based on the problem.
                count++;
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}