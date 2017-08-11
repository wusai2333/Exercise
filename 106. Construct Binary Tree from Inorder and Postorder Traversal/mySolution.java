import java.util.HashMap;

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
    Map<Integer, Integer> mapToIn = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            mapToIn.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = mapToIn.get(postorder[postEnd]);
        int rightLength = inEnd - rootIndex;
        root.right = buildTree(inorder, postorder, postEnd-1, rootIndex+1, inEnd);
        root.left = buildTree(inorder, postorder, postEnd-rightLength-1, inStart, rootIndex-1);
        return root;
    }
}