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
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> (e2.getValue() - e1.getValue()));
        int target = list.get(0).getValue();
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() == target) {
                res.add(entry.getKey());
            } else {
                break;
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