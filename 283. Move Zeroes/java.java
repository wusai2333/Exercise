<<<<<<< HEAD
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        
        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }
        while(insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
=======
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        
        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }
        while(insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
}