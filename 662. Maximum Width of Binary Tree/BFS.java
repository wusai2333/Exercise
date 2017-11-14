class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root, 1));

        while (!q.isEmpty()) {
            int size = q.size();
            int l = q.peek().getValue(), r = l;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.peek().getKey();
                r = q.poll().getValue();
                if (node.left != null) q.offer(new AbstractMap.SimpleEntry(node.left, 2 * r));
                if (node.right != null) q.offer(new AbstractMap.SimpleEntry(node.right, 2 * r + 1));
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}