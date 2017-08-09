import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), res);
        return res;
    }

    public void backTrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                backTrack(nums, list, res);
                list.remove(list.size()-1);
            }
        }
    }
}