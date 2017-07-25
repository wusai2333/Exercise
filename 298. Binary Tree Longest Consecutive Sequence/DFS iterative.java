import java.util.Stack;

public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode, Integer>(root, 1));
        int max = 1;
        while(!stack.empty()) {
            Pair pair = stack.pop();
            TreeNode node = (TreeNode)pair.first;
            int length = (int)pair.second;
            max = Math.max(length, max);
            if (node.left != null) {
                int left = (node.left.val == node.val + 1) ? length + 1: 1;
                stack.push(new Pair(node.left, left));
            }
            if (node.right != null) {
                int right = (node.right.val == node.val + 1) ? length + 1: 1;
                stack.push(new Pair(node.right, right));
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