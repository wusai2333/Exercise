class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Node> map = new HashMap<>();
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            String s1 = equations[i][0], s2 = equations[i][1];
            if (!map.containsKey(s1) && !map.containsKey(s2)) {
                map.put(s1, new Node());
                map.put(s2, new Node());
                map.get(s1).value = values[i];
                map.get(s2).value = 1.0;
                map.get(s1).parent = map.get(s2);
            } else if (!map.containsKey(s1)) {
                map.put(s1, new Node());
                map.get(s1).value = map.get(s2).value * values[i];
                map.get(s1).parent = map.get(s2);
            } else if (!map.containsKey(s2)) {
                map.put(s2, new Node());
                map.get(s2).value = map.get(s1).value / values[i];
                map.get(s2).parent = map.get(s1);
            } else {
                unionNodes(map.get(s1), map.get(s2), values[i], map);
            }
        }

        for (String[] query : queries) {
            if (!map.containsKey(query[0]) || !map.containsKey(query[1]) || findParent(map.get(query[0])) != findParent(map.get(query[1])) )
                result.add(-1.0);
            else 
                result.add(map.get(query[0]).value / map.get(query[1]).value);
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    private class Node {
        Node parent;
        double value = 0.0;
        public Node() {parent = this;}
    }

    private void unionNodes(Node node1, Node node2, double num, Map<String, Node> map) {
        Node parent1 = findParent(node1);
        Node parent2 = findParent(node2);
        double ratio = node2.value * num / node1.value;
        for (Map.Entry<String, Node> entry : map.entrySet()) {
            if (findParent(entry.getValue()) == parent1) {
                entry.getValue().value *= ratio;
            }
        }
        parent1.parent = parent2;
    }

    private Node findParent(Node node) {
        if (node.parent == node) {
            return node;
        }
        node.parent = findParent(node.parent);
        return node.parent;
    }
}