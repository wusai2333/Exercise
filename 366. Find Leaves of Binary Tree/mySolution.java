import java.util.ArrayList;

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }

    private int height(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int leftLevel = height(node.left, res);
        int rightLevel = height(node.right, res);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        node.left = node.right = null;
        return level;
    }
}