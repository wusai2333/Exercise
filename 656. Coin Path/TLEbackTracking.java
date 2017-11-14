// This solution will get a TLE.
class Solution {
    int cost;
    public List<Integer> cheapestJump(int[] A, int B) {
        List<List<Integer>> result = new ArrayList<>();
        cost = Integer.MAX_VALUE;
        backTrace(A, B, result, new ArrayList<>(Arrays.asList(1)), 1, A[0]);
        return result.isEmpty() ? new ArrayList<Integer>(): result.get(0);
    }
    
    private class listComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> l1, List<Integer> l2) {
            int n = Math.min(l1.size(), l2.size());
            for (int i = 0; i < n; i++) {
                if (l1.get(i) != l2.get(i)) {
                    return l1.get(i) - l2.get(i);
                }
            }
            return 0;
        }
    }
    
    void backTrace(int[] A, int B, List<List<Integer>> result, List<Integer> list, int start, int curCost) {
        if (start == A.length && curCost <= cost) {
            if (curCost < cost) {
                cost = curCost;
                result.clear();
            }
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start + 1; i <= Math.min(start + B, A.length); i++) {
            if (A[i - 1] == -1) continue;
            list.add(i);
            backTrace(A, B, result, list, i, curCost + A[i - 1]);
            list.remove(list.size() - 1);
        }
    }
}