class Solution {
    int maxval = 0;
    public int longConsecutivePath(TreeNode root) {
        longestPath(root);
        return maxval;
    }

    private int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1) {
                dcr = l[0] + 1;
            } else if (root.val == root.left.val - 1) {
                inr = l[1] + 1;
            }
        }
        if (root.right != null) {
            int[] l = longestPath(root.right);
            if (root.val == root.right.val + 1) {
                dcr = Math.max(dcr, l[0] + 1);
            } else if (root.val == root.right.val - 1) {
                inr = Math.max(inr, l[1] + 1);
            }
        }
        maxval = Math.max(maxval, inr + dcr - 1);
        return new int[]{dcr, inr};
    }
}