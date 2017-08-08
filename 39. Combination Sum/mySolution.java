import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public void backTrack(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            comb.add(candidates[i]);
            backTrack(candidates, target-candidates[i], i, comb, res);
            comb.remove(comb.size()-1);
        }
    }
}