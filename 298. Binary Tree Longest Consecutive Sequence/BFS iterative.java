import java.util.Queue;

public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = (TreeNode) pair.first;
            int length = (int) pair.second;
            max = Math.max(max, length);
            if (node.left != null) {
                int left = (node.left.val == node.val + 1) ? length + 1: 1;
                queue.offer(new Pair(node.left, left));
            }
            if (node.right != null) {
                int right = (node.right.val == node.val + 1) ? length + 1: 1;
                queue.offer(new Pair(node.right, right));
            }
        }
        return max;
    }

    private class Pair<First, Second> {
        First first;
        Second second;
        public Pair(First f, Second s) {
            first = f;
            second = s;
        }
        
    }
}