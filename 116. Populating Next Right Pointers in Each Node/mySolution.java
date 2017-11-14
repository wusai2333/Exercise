class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        TreeLinkNode prev = null;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = q.poll();
                if (prev != null) prev.next = node;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                prev = node;
            }
            prev.next = null;
            prev = null;
        }
    }
}