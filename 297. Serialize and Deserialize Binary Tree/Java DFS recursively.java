public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    private void dfs(TreeNode x, StringBuilder sb) {
        if (x==null) {
            sb.append("null ");
            return;
        }
        sb.append(String.valueOf(x.val));
        sb.append(' ');
        dfs(x.left, sb);
        dfs(x.right, sb);
    }
    public TreeNode deserialize(String data) {
        String[] node = data.split(" ");
        int[] d = new int[1];
        return dfs(node, d);
    }

    private TreeNode dfs(String[] node, int[] d) {
        //The Int [] d= new int[] is similar to the Pointer in C. it allocates the memory in heap. d is index of string, so you can traverse the entire string.
        if (node[d[0]].equals("null") {
            d[0]++;
            return null;
        }
        TreeNode x = new TreeNode(Integer.valueOf(node[d[0]]));
        d[0]++;
        x.left = dfs(node, d);
        x.right = dfs(node, d);
        return x;
    }
}
