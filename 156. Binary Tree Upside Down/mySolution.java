import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
// get a TLE or MLE;
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> leftAndRight = new HashMap<>();
        Stack<TreeNode> leftChild = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode leftNode = null;
            TreeNode rightNode = null;
            for (int i = 0; i < size; i ++) {
                if (i == 0) {
                    leftNode = queue.poll();
                    leftChild.push(leftNode);
                    if (leftNode.left != null) queue.offer(leftNode.left);
                    if (leftNode.right != null) queue.offer(leftNode.right);
                }
                else if (i == 1) {
                    rightNode = queue.poll();
                    leftAndRight.put(leftNode, rightNode);
                    if (rightNode.left != null) queue.offer(rightNode.left);
                    if (rightNode.right != null) queue.offer(rightNode.right);
                }
                
            }
        }

        TreeNode newRoot = leftChild.pop();

        TreeNode node = newRoot;
        while (!leftChild.empty()) {
            TreeNode rightNode = leftChild.pop();
            if (!leftAndRight.containsKey(rightNode)) node.left = leftAndRight.get(rightNode);
            node.right = rightNode;
            node = node.right;
        }

        return newRoot;
    }
}