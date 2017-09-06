// backTracking
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) return res;
        combination(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    private void combination(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++ ) {
            list.add(i);
            combination(n, k - 1, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}