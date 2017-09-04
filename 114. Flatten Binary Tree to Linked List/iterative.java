class Solution {
    public void flatten(TreeNode root) {
        TreeNode now = root;
        while (now != null) {
            if (now.left != null) {
                // FIND THE CURRENT NODE'S PRENODE THAT LINKS TO CURRENT NDOES RIGHT SUBTREE.
                TreeNode prev = now.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = now.right;
                // use current node's left subtree to replace its right subtree(original right).
                // subtree is already linked by current node's prenode
                now.right = now.left;
                now.left = null;
            }
            now = now.right;
        }
    }
}