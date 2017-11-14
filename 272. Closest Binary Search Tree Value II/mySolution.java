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

    // 1. O(nk) not good solution
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            int i = list.size();
            while (i > 0 && Math.abs(list.get(i-1) - target) > Math.abs(node.val -       
                    target)) {
                i--;
            }
            list.add(i, node.val);
            while (list.size() > k) list.remove(list.size() - 1);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return list;
    }

    // 2.O(n) time using two Stack O(n) space inorder traversal;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        inorder(root, target, false, s1);
        inorder(root, target, true, s2);

        while (k-- > 0) {
            if (s1.empty()) {
                result.add(s2.pop());
            } else if (s2.empty()) {
                result.add(s1.pop());
            } else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) {
                result.add(s1.pop());
            } else {
                result.add(s2.pop());
            }
        }
        return result;
    }

    private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if (root == null) return;
        inorder(reverse ? root.right : root.left, target, reverse, stack);

        if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
        stack.push(root.val);
        inorder(reverse ? root.left : root.right, target, reverse, stack);
    }

    // 3.O(K + logN) solution using two stacks less than O(N) time;
    public List<Integer> closestKValues(TreeNode root, double target,    int k) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initializePredecessorStack(root, target, pred);
        initializeSuccessorStack(root, target, succ);
        if (!succ.empty() && !pred.empty() && succ.peek().val == pred.peek().val) {
            getNextPredecessor(pred);
        }

        while (k-- >0) {
            if (succ.empty()) {
                result.add(getNextPredecessor(pred));
            } else if (pred.empty()) {
                result.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs((double) succ.peek().val - target);
                double pred_diff = Math.abs((double) pred.peek().val - target);
                if (succ_diff < pred_diff) {
                    result.add(getNextSuccessor(succ));
                } else {
                    result.add(getNextPredecessor(pred));
                }
            }
        }
        return result;
    }

    void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                break;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode cur =  pred.pop();
        int result = cur.val;
        cur = cur.left;
        while (cur != null) {
            pred.push(cur);
            cur = cur.right;
        }
        return result;
    }

    private int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode cur = succ.pop();
        int result = cur.val;
        cur = cur.right;    
        while (cur != null) {
            succ.push(cur);
            cur = cur.left;
        }
        return result;
    }
}