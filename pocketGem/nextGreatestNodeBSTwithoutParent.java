import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode nextGreatest(TreeNode root, TreeNode t) {
        TreeNode temp = t;
        if (t != null && t.right != null) return getLeftMost(t.right);
        List<TreeNode> list = getAncenssor(root, t);
        int i = 2;
        while (list.size() - i >= 0) {
            TreeNode parent = list.get(list.size()-i);
            if (parent.left == t) return parent;
            t = parent;
            i ++;
        }
        return temp;
    }

    private List<TreeNode> getAncenssor(TreeNode root, TreeNode t) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        backTrack(root, t, res, new ArrayList<>());
        return res;
    }

    private void backTrack(TreeNode root, TreeNode t, List<TreeNode> res, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        if (root == t) {
            res.addAll(new ArrayList<TreeNode>(list));
            return;
        }
        backTrack(root.left, t, res, list);
        backTrack(root.right, t, res, list);
        list.remove(list.size()-1);
    }

    private TreeNode getLeftMost(TreeNode t) {
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }
}

public class nextGreatestNodeBSTwithoutParent {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode (2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Solution solution = new Solution();
        TreeNode t = solution.nextGreatest(root, root.right.left);
        System.out.println(t.val);
    }
}