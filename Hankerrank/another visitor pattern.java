import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;
    public int getResult() {
      	//implement this
        return sum;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int M = 1000000007;
    public int getResult() {
      	//implement this
        return (int)product;
    }

    public void visitNode(TreeNode node) {
      	//implement this
        if (node.getColor().equals(Color.RED)) {
            product = (product * (long)node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        if (leaf.getColor().equals(Color.RED)) {
            product = (product * (long)leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenSum = 0;
    private int greenSum = 0;
    public int getResult() {
      	//implement this
        return Math.abs(evenSum - greenSum);
    }

    public void visitNode(TreeNode node) {
    	//implement this
        if (node.getDepth() % 2 == 0) {
            evenSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
        if (leaf.getColor().equals(Color.GREEN)) {
            greenSum += leaf.getValue();
        }
    }
}

public class Solution {
    private static int[] values;
    private static Color[] colors;
    private static Map<Integer, HashSet<Integer>> map = new HashMap<>();
    private static boolean[] mark;
    private static int N;

    public static Tree dfs(int vertex) {
        if (map.get(vertex).isEmpty())
            return new TreeLeaf(values[vertex], colors[vertex], 0);
        else {
            mark = new boolean[N];
            return runDfs(vertex, 0);
        }
    }

    public static Tree runDfs(int vertex, int depth) {
        mark[vertex] = true;
        ArrayList<Tree> childs = new ArrayList<>();
        for (Integer e : map.get(vertex)) {
            if (!mark[e]) {
                childs.add(runDfs(e, depth+1));
            }
        }
        if (childs.isEmpty()) {
            return new TreeLeaf(values[vertex], colors[vertex], depth);
        } else {
            TreeNode node = new TreeNode(values[vertex], colors[vertex], depth);
            for (Tree child : childs) {
                node.addChild(child);
            }
            return node;
        }
    }
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        values = new int[N];
        colors = new Color[N];

        for (int i = 0; i < N; i++) {
            values[i] = scan.nextInt();
            map.put(i, new HashSet<Integer>());
            //System.out.print(values[i] + " ");
        }
        //System.out.println();
        for (int i = 0; i < N; i++) {
            Color color = (scan.nextInt() == 0) ? Color.RED : Color.GREEN;
            colors[i] = color;
            //System.out.print(colors[i] + " ");
        }
        for (int i = 0; i < N-1; i++) {
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;
            map.get(u).add(v);
            map.get(v).add(u);
        }
        return dfs(0);
    }
    public static void main(String[] args) {
        Tree root = solve();
      SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
       System.out.println(res2);
      System.out.println(res3);
  }
}  