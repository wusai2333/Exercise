import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<Integer>(), 0, res);
        return res;
    }

    public void backTrack(int[] nums, List<Integer> list, int start, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(list));
        for(int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i-1]) {
                list.add(nums[i]);
                backTrack(nums, list, i+1, res);
                list.remove(list.size()-1);
            }
        }
    }
}