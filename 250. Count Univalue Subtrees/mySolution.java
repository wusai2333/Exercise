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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isUnival(root);
        return count;
    }
    
    private Integer isUnival(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            count++;
            return root.val;
        }
        if (root.left == null) {
            Integer right = isUnival(root.right);
            if (right == null) return null;
            if (right == root.val) {
                count ++;
                return right;
            } else return null;
        } else if (root.right == null) {
            Integer left = isUnival(root.left);
            if (left == null) return null;
            if (left == root.val) {
                count ++;
                return left;
            } else return null;
        } else {
            Integer left = isUnival(root.left);
            Integer right = isUnival(root.right);
            if (left != null && right != null && left == root.val && right == root.val) {
                count ++;
                return left;
            }
            else return null;
        }
        
    }
}