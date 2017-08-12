public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            int num = findNums[i];
            int index = 0;
            for (int j = 0; j < nums.length; j ++) {
                if (nums[j] == num) {
                    index = j;
                    break;
                } 
            }
            index += 1;
            while (index < nums.length && nums[index] <= num) {index++;}
            if (index == nums.length) res[i] = -1;
            else res[i] = nums[index];
        }
        return res;
    }
}