class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        int index = n - 1;
        while (index > 0) {
            if (nums[index - 1] < nums[index]) {
                break;
            }
            index --;
        }
        if (index == 0) {
            reverse(nums, 0, n-1);
        } else {
            int val = nums[index - 1];
            int j = n - 1;
            while (j >= index) {
                if (nums[j] > val) break;
                j --;
            }
            exch(nums, index-1, j);
            reverse(nums, index, n - 1);
        }

    }
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i , int j) {
        while (i < j) exch(nums, i++, j--);
    }
}