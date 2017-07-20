public class Solution {
    private TreeNode target = null;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorderTraversal(root);
        return target.val;
    }

     private void inorderTraversal(TreeNode node) {
         if (node == null) return;
        inorderTraversal(node.left);
        if (--this.k == 0) {this.target = node;}
        inorderTraversal(node.right);
    }
}