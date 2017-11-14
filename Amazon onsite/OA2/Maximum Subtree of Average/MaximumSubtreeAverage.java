import java.util.*;
class Node {
    int val;
    ArrayList<Node> children;
    public Node (int x) {
        val = x;
        children = new ArrayList<Node>();
    }
}
public class MaximumSubtreeAverage {
    static class Pair {
        int sum; 
        int count;
        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    static Node ans;
    static double max = 0;
    public static Node find(Node root) {
        ans = null;
        max = 0;
        dfs(root);
        return ans;
    }

    private static Pair dfs(Node root) {
        if (root == null) return new Pair(0, 0);
        if (root.children == null || root.children.size() == 0) return new Pair(root.val, 1);
        int sum = root.val;
        int count = 1;
        for (Node child: root.children) {
            Pair sumAndCount = dfs(child);
            sum += sumAndCount.sum;
            count += sumAndCount.count;
        }
        if (count > 1 && (1.0*sum) / count > max) {
            max = (1.0* sum) / count;
            ans = root;
        }
        return new Pair(sum, count);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);
 
        l21.children.add(l31);
        l21.children.add(l32);
 
        l22.children.add(l33);
        l22.children.add(l34);
 
        l23.children.add(l35);
        l23.children.add(l36);
 
        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);
 
        Node res = find(root);
        System.out.println(res.val + " " + max);
    }
}