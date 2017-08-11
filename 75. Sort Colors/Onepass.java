public class Solution {
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length-1;
        for (int i = 0; i < nums.length; i ++) {
            while (nums[i] == 2 && i < blue) {
                int temp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = temp;
                blue --;
            }
            while (nums[i] == 0 && i > red) {
                int temp = nums[i];
                nums[i] = nums[red];
                nums[red] = temp;
                red ++;
            }
        }
    }
}