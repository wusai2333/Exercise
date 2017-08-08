import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0 || k <= 0) return res;
        backTrack(new ArrayList<Integer>(), k, 1, n);
        return res;
    }
    public void backTrack(List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            backTrack(comb, k, i+1, n-i);
            comb.remove(comb.size()-1);
        }
    }
}