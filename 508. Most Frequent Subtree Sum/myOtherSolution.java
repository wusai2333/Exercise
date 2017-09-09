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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        if (root.left == null && root.right == null) return new int[]{root.val};
        Map<Integer, Integer> map = new HashMap<>();
        sum(root, map);
        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    private int sum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int s = root.val + sum(root.left, map) + sum(root.right, map);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}