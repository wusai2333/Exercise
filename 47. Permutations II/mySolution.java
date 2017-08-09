import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<Integer>(), res, new boolean[nums.length]);
        return res;
    }

    public void backTrack(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] used) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]|| i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            list.add(nums[i]);
            backTrack(nums, list, res, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}