public class Solution {
    Map<String, GraphNode> map = null;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];
        map = new HashMap<String, GraphNode>();
        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            if (!map.containsKey(a) && !map.containsKey(b)) {
                GraphNode nodeA = new GraphNode(values[i]);
                GraphNode nodeB = new GraphNode(1.0);
                map.put(a, nodeA);
                map.put(b, nodeB);
                nodeA.parent = nodeB;
                nodeB.children.add(nodeA);
            } else if (!map.containsKey(b)) {
                GraphNode nodeA = map.get(a);
                GraphNode nodeB = new GraphNode(nodeA.value / values[i]);
                GraphNode parentA = root(nodeA);
                nodeB.parent = parentA;
                parentA.children.add(nodeB);
                map.put(b, nodeB);
            } else if (!map.containsKey(a)) {
                GraphNode nodeB = map.get(b);
                GraphNode nodeA = new GraphNode(nodeB.value * values[i]);
                GraphNode parentB = root(nodeB);
                nodeA.parent = parentB;
                parentB.children.add(nodeA);
                map.put(a, nodeA);
            } else {
                union(map.get(a), map.get(b), values[i]);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            if (!map.containsKey(a) || !map.containsKey(b) || root(map.get(a)) != root(map.get(b))) {
                result[i] = -1.0;
            } else {
                result[i] = map.get(a).value / map.get(b).value;
            }
        }
        return result;
    }


    private class GraphNode {
        double value;
        GraphNode parent;
        List<GraphNode> children;
        int size;
        GraphNode(double value) {
            this.value = value;
            size = 1;
            children = new ArrayList<>(Arrays.asList(this));
            parent = this;
        }
    }
    private GraphNode root(GraphNode node) {
        while (node != node.parent) {
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }
    private void union(GraphNode node1, GraphNode node2, double value) {
        GraphNode parent1 = root(node1);
        GraphNode parent2 = root(node2);
        if (parent1 == parent2) {
            return;
        }
        if (parent1.size < parent2.size) {
            unionHelper(node1, node2, value);
        } else {
            unionHelper(node2, node1, 1/value);
        }
    }
    private void unionHelper(GraphNode node1, GraphNode node2, double value) {
        GraphNode parent1 = root(node1);
        GraphNode parent2 = root(node2);
        double ratio = node2.value * value / node1.value;
        for (GraphNode child : parent1.children) {
            child.value *= ratio;
            child.parent = parent2;
            parent2.children.add(child);
            parent2.size++;
        }
    }
}