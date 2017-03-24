/**
* Definition for a binary tree node.
* public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {val = x;}
}
*/
public class Codec {
    private static final String spliter = ",";//split node with"."
    private static final String NN = "X";// use "X" to denote null node

    //Encode a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encode data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();//Deque.remove() is equivalent to Deque.removeFirst()
        if(val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(nodes));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return nodes;
        }
/**The equals() method compares the "value" inside String instances (on the heap) irrespective if the two object references refer to the same String instance or not. If any two object references of type String refer to the same String instance then great! If the two object references refer to two different String instances .. it doesn't make a difference. Its the "value" (that is: the contents of the character array) inside each String instance that is being compared.

On the other hand, the "==" operator compares the value of two object references to see whether they refer to the same String instance. If the value of both object references "refer to" the same String instance then the result of the boolean expression would be "true"..duh. If, on the other hand, the value of both object references "refer to" different String instances (even though both String instanceshave identical "values", that is, the contents of the character arrays of each String instance are the same) the result of the boolean expression would be "false".
**/

    }
}
