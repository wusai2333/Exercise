
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
    int maxSize = 0;
    public int largestBSTSubtree(TreeNode root) {
        isBST(root);
        return maxSize;
    }

    private int[] isBST(TreeNode root) {
        // return  3 element array:
        // # of nodes in the subtree, left most value and right most value;
        // # of nodes would be -1 if it is not a BST
        int[] result = new int[3];
        if (root == null) {
            return result;
        }
        int[] leftResult = isBST(root.left);
        int[] rightResult = isBST(root.right);
        if ((leftResult[0] == 0 || leftResult[0] > 0 && leftResult[2] < root.val) &&
            (rightResult[0] == 0 || rightResult[0] > 0 && rightResult[1] > root.val)) {
            int size = 1 + leftResult[0] + rightResult[0];
            if (maxSize < size) maxSize = size;
            result[0] = size;
            result[1] = leftResult[0] == 0 ? root.val : leftResult[1];
            result[2] = rightResult[0] == 0 ? root.val: rightResult[2];
        } else {
            result[0] = -1;
        }
        return result;
    }
}