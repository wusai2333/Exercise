<<<<<<< HEAD
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class Codec {
     //encode a tree to a single string.
     public String serialize(TreeNode root) {
         if (root == null) return "";
         Queue<TreeNode> q = new LinkedList<>();
         StringBuilder res = new StringBuilder();
         q.add(root);
         while(!q.isEmpty()) {
             TreeNode node = q.poll();
             if (node == null) {
                 res.append("n ");
                 continue;
             }
             res.append(node.val + " ");
             q.add(node.left);
             q.add(node.right);
         }
         return res.toString();
     }

     public TreeNode deserialize(String data) {
         if (data == "") return null;
         Queue<TreeNode> q = new LinkedList<>();
         String[] values = data.split(" ");
         TreeNode root = new TreeNode(Integer.parseInt(values[0]));
         q.add(root);
         for (int i = 1; i < values.length; i++) {
             TreeNode parent = q.poll();
             if(!values[i].equals("n")) {
                 TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                 parent.left = left;
                 q.add(left);
             }
             if (!values[++i].equals("n")) {
                 TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                 parent.right = right;
                 q.add(right);
             }
         }
         return root;
     }
 }
=======
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class Codec {
     //encode a tree to a single string.
     public String serialize(TreeNode root) {
         if (root == null) return "";
         Queue<TreeNode> q = new LinkedList<>();
         StringBuilder res = new StringBuilder();
         q.add(root);
         while(!q.isEmpty()) {
             TreeNode node = q.poll();
             if (node == null) {
                 res.append("n ");
                 continue;
             }
             res.append(node.val + " ");
             q.add(node.left);
             q.add(node.right);
         }
         return res.toString();
     }

     public TreeNode deserialize(String data) {
         if (data == "") return null;
         Queue<TreeNode> q = new LinkedList<>();
         String[] values = data.split(" ");
         TreeNode root = new TreeNode(Integer.parseInt(values[0]));
         q.add(root);
         for (int i = 1; i < values.length; i++) {
             TreeNode parent = q.poll();
             if(!values[i].equals("n")) {
                 TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                 parent.left = left;
                 q.add(left);
             }
             if (!values[++i].equals("n")) {
                 TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                 parent.right = right;
                 q.add(right);
             }
         }
         return root;
     }
 }
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
