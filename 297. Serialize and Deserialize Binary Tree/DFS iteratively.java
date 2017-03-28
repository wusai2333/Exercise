<<<<<<< HEAD
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode x = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while(x != null || !stack.isEmpty()) {
            if (x!=null) {
                sb.append(String.valueOf(x.val));
                sb.append(" ");
                stack.push(x);
                x = x.left;
            } else {
                sb.append("null ");
                x = stack.pop();
                x = x.right;
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] node = data.split(" ");
        int n = node.length;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        TreeNode x = root;
        stack.push(x);
        int i = 1;
        while (i < n) {
            while (i < n && node[i].equals("null")) {
                x.left = new TreeNode(Integer.valueOf(node[i++]));
                x = x.left;
                stack.push(x);
            }
            while (i < n && node[i].equals("null")) {
                x = stack.pop();
                i++;
            }
            if (i < n) {
                x.right = new TreeNode(Integer.parseInt(node[i++]));
                x = x.right;
                stack.push(x);
            }
        }
        return root;
    }
}
=======
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode x = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while(x != null || !stack.isEmpty()) {
            if (x!=null) {
                sb.append(String.valueOf(x.val));
                sb.append(" ");
                stack.push(x);
                x = x.left;
            } else {
                sb.append("null ");
                x = stack.pop();
                x = x.right;
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] node = data.split(" ");
        int n = node.length;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        TreeNode x = root;
        stack.push(x);
        int i = 1;
        while (i < n) {
            while (i < n && node[i].equals("null")) {
                x.left = new TreeNode(Integer.valueOf(node[i++]));
                x = x.left;
                stack.push(x);
            }
            while (i < n && node[i].equals("null")) {
                x = stack.pop();
                i++;
            }
            if (i < n) {
                x.right = new TreeNode(Integer.parseInt(node[i++]));
                x = x.right;
                stack.push(x);
            }
        }
        return root;
    }
}
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
