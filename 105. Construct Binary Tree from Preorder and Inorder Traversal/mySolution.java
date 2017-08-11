
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder == null) return null;
        for (int i = 0; i < preorder.length; i++) {
            mapToIn.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length-1);
        
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length -1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = mapToIn.get(preorder[preStart]);
        int leftLength = rootIndex - inStart;
        root.left = buildTree(preorder, inorder, preStart+1, inStart, rootIndex-1);
        root.right = buildTree(preorder, inorder, preStart+leftLength+1, rootIndex+1, inEnd);
        return root;
    }
}