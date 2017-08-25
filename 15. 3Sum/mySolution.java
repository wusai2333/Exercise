import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i-1]) {
                int start = i + 1, end = nums.length - 1, target = - nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] == target) {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start+1] == nums[start]) start ++;
                        while (start < end && nums[end-1] == nums[end]) end--;
                        start ++;
                        end --;
                    }
                    else if(nums[start] + nums[end] < target) start ++;
                    else end--;
                }
            }
        }
        return res;
    }
}