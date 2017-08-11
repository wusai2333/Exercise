public class Codec {
    private static final String NULL = "null";
    private static final String SEP = ",";
    public String serialize(TreeNode root) {
        if (root == null) return NULL;
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) { 
        if (data.equals(NULL)) return null;
        String[] nodeStrs = data.split(SEP);
        int[] nodes = new int[nodeStrs.length];
        int i = 0;
        for (String s: nodeStrs) {
            nodes[i++] = Integer.parseInt(s);
        }
        return deserialize(nodes, 0, nodes.length-1);
    }

    private TreeNode deserialize(int[] nodes, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nodes[start]);
        // the next number is not part of current subtree, should return null;
        int leftEnd = start, rightStart = start+1;
        TreeNode root = new TreeNode(nodes[start]);
        for (int i = start+1; i < nodes.length; i++) {
            if (nodes[i] > root.val) break;
            leftEnd = i;
            rightStart = i + 1;
        }
        root.left = deserialize(nodes, start+1, leftEnd);
        root.right = deserialize(nodes, rightStart, end);
        return root;
    }
}