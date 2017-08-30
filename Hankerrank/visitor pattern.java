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
    private static Map<Integer, Set<Integer>> nodesMap = new HashMap<>();
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scan = new Scanner(System.in);
        int numOfNodes = scan.nextInt();
        values = new int[numOfNodes];
        colors = new Color[numOfNodes];
    
        
        for (int i = 0; i < numOfNodes; i++) {
            values[i] = scan.nextInt();
            //System.out.print(values[i] + " ");
        }
        //System.out.println();
        for (int i = 0; i < numOfNodes; i++) {
            Color color = (scan.nextInt() == 0) ? Color.RED : Color.GREEN;
            colors[i] = color;
            //System.out.print(colors[i] + " ");
        }
        Tree root;
        if (numOfNodes == 1) {
            root = new TreeLeaf(values[0], colors[0], 0);
        } else {
            for (int i = 0; i < numOfNodes -1; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                Set<Integer> uEdges = nodesMap.get(u);
                if (uEdges == null) {
                    uEdges = new HashSet<>();
                }
                uEdges.add(v);
                nodesMap.put(u, uEdges);
                Set<Integer> vEdges = nodesMap.get(v);
                if (vEdges == null) {
                    vEdges = new HashSet<>();
                }
                vEdges.add(u);
                nodesMap.put(v, vEdges);
            }
            root = new TreeNode(values[0], colors[0], 0);
            Set<Integer> rootEdges = nodesMap.get(0);
            for (Integer nodeIdentifier : rootEdges) {
                nodesMap.get(nodeIdentifier).remove(0);
                createEdge(root, nodeIdentifier);
            }
        }
        return root;
       //System.out.println();
    }

    private static void createEdge(Tree parentNode, Integer nodeIdentifier) {
        Set<Integer> nodeEdges = nodesMap.get(nodeIdentifier);
        boolean hasChild = false;
        if (nodeEdges != null && !nodeEdges.isEmpty()) {
            hasChild = true;
        }

        if (hasChild) {
            TreeNode node = new TreeNode(values[nodeIdentifier], colors[nodeIdentifier], parentNode.getDepth()+1);
            ((TreeNode) parentNode).addChild(node);
            Iterator<Integer> nodeIterator = nodeEdges.iterator();
            while (nodeIterator.hasNext()) {
                Integer neighborNodeIdentifier = nodeIterator.next();
                nodesMap.get(neighborNodeIdentifier).remove(nodeIdentifier);
                createEdge(node, neighborNodeIdentifier);
            }
        } else {
            TreeLeaf leaf = new TreeLeaf(values[nodeIdentifier], colors[nodeIdentifier], parentNode.getDepth() + 1);
            ((TreeNode)parentNode).addChild(leaf);
        }
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