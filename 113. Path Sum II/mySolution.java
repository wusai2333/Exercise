class Solution {
    public List<List<Integer>> pathSum (TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(root, sum, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrace(TreeNode root, int sum, int cur, List<Integer> list, List<List<Integer>> result) {
        if (root == null) return;
        list.add(root.val);
        cur += root.val;
        if (root.left == null && root.right == null) {
            if (cur == sum) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        if (root.left != null) {
            backTrace(root.left, sum, cur, list, result);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            backTrace(root.right, sum, cur, list, result);
            list.remove(list.size() - 1);
        }
    }
}