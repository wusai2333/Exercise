import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backTrack(candidates, new ArrayList<>(), 0, target, new boolean[candidates.length], res);
        return res;
    }

    private void backTrack(int[] candidates, List<Integer> comb, int start,int target, boolean[] used, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            comb.add(candidates[i]);
            used[i] = true;
            backTrack(candidates, comb, i+1, target-candidates[i], used, res);
            used[i] = false;
            comb.remove(comb.size()-1);
        }
    }
}