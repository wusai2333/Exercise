class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        backTrace(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    void backTrace(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            backTrace(nums, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}