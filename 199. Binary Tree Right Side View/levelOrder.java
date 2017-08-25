class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // reverse the traversal
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                if (cur.right != null) queue.add(cur.right);
                if (cur.left != null) queue.add(cur.left);
            }
        }
        return result;
    }
}