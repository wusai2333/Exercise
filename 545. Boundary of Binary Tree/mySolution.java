import java.util.ArrayList;
import java.util.List;

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            if (root == null) return res;
            res.add(root.val);   
            leftBoarder(root.left);
            leaves(root.left);
            leaves(root.right);
            rightBoarder(root.right);
            return res;
        }

        private void leftBoarder(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return;
            res.add(root.val);
            if (root.left != null) leftBoarder(root.left);
            else leftBoarder(root.right);
        }

        private void leaves(TreeNode root) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                res.add(root.val);
                return;
            }
            leaves(root.left);
            leaves(root.right);
        }

        private void rightBoarder(TreeNode root) {
            if (root == null || root.left == null && root.right == null) return;
            if (root.right != null) rightBoarder(root.right);
            else rightBoarder(root.left);
            res.add(root.val);
        }
    }