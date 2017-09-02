
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxSize = 1;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        isBST(root);
        return maxSize;
    }

    private int isBST(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int size = 1;
        if (root.left != null && root.left.val < root.val) {
            size += isBST(root.left);
        }
        if (root.right != null && root.right.val > root.val) {
            size += isBST(root.right);
        }
        if (size > maxSize) maxSize = size;
        return size;
    }
}