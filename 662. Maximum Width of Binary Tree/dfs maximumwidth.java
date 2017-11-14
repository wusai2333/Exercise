/**
 * binary tree can be represented by an array, if the index node is i(assume the start index is 1), the indices of its two chidren are 2*i and 2 * i + 1; use two list to record the indices of left most node and right most node in each level; start[level] and end[level]
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    private int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (start.size() == level) {
            start.add(order); end.add(order);
        }
        else end.set(level, order);

        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2 * order, start, end);
        int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }


    
}