import java.util.Arrays;

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "NULL";
        StringBuilder sb = new StringBuilder();
        preorder(sb, root);
        return sb.toString();
    }

    private void preorder(StringBuilder sb, TreeNode root) {
        if (root != null) {
            sb.append(root.val).append(",");
            preorder(sb, root.left);
            preorder(sb, root.right);
        }
    }
    public TreeNode deserialize(String data) {
        if (data.equals("NULL")) return null;
        String[] temp = data.split(",");
        int[] preorder = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            preorder[i] = Integer.parseInt(temp[i]);
        }
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        return buildTree(preorder, inorder);
    }

    Map<Integer, Integer> mapToIn = new HashMap<>();
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder == null) return null;
        for (int i = 0; i < preorder.length; i++) {
            mapToIn.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length-1);
        
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length -1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = mapToIn.get(preorder[preStart]);
        int leftLength = rootIndex - inStart;
        root.left = buildTree(preorder, inorder, preStart+1, inStart, rootIndex-1);
        root.right = buildTree(preorder, inorder, preStart+leftLength+1, rootIndex+1, inEnd);
        return root;
    }
}