/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }
        
        private void pushAll(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    
        /** @return the next smallest number */
        public int next() {
            TreeNode tempNode = stack.pop();
            pushAll(tempNode.right);
            return tempNode.val;
        }
    }
    
    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */