import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, res, new ArrayList<>(), 0);
        return res;
    }
    
    public void backTrack(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, res, list, i+1);
            list.remove(list.size()-1);
        }
    }
}