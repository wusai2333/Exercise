public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatePreorderString(s);
        String tpreorder = generatePreorderString(t);

        return kmp(spreorder, tpreorder);
    }

    private String generatePreorderString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                sb.append(",#");
            }
            else {
                sb.append("," + node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return sb.toString();
    }

    private boolean kmp(String s, String t) {
        int i = 0, j = 0;
        int n = s.length();
        int m = t.length();
        if (m == 0) return true;
        int[] next = new int[m];
        getNext(t, next);
        while (i < n && j < m) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == m) return true;
        else return false;
    }

    private void getNext(String t, int[] next) {
        int len = t.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            if (k == -1 || t.charAt(k) == t.charAt(j)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }
}