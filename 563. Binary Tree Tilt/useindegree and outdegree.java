class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) return true;
        String[] nodes = preorder.split(",");
        int diff = 1; // because the root has 2 two outdegree and no indegree.
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}