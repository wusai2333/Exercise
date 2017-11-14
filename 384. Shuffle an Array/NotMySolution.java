import java.util.Random;

class Solution {
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] shuffle() {
        if (nums == null) return null;
        int[] res = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i+1);
            swap(nums, i, j);
        }
        return res;
    }

    public int[] reset() {
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}