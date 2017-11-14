class Solution {
     public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, t);
        return sb;
    }

    private void dfs(StringBuilder sb, TreeNode t) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left != null || t.right != null) {
            sb.append('(');
            dfs(sb, t.left);
            sb.append(')');
            if (t.right != null) {
                sb.append('(');
                dfs(sb, t.right);
                sb.append(')');
            }
        }
    }
}