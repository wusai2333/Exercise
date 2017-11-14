import java.util.*;
class OrderDependency {
    String pre;
    String next;
    OrderDependency(String n, String p) {
        pre = p;
        next = n;
    }
}

public class FindOrder {
    public static String[] findOrder(List<OrderDependency> list) {
        Map<String, Integer>  indegree = new HashMap<String, Integer>();
        Map<String, List<String>> adjs = new HashMap<String, List<String>>();
        initializeGraph(list, adjs, indegree);
        return solveByBFS(indegree, adjs);
    }

    private static void initializeGraph(List<OrderDependency> list,Map<String, List<String>> adjs, Map<String, Integer> indegree) {
        for (OrderDependency order: list) {
            String pre = order.pre;
            String next = order.next;
            if (!indegree.containsKey(pre)) {
                indegree.put(pre, 0);
                adjs.put(pre, new ArrayList<String>());
            }
            if (!indegree.containsKey(next)) {
                indegree.put(next, 0);
                adjs.put(next, new ArrayList<String>());
            }
            indegree.put(next, indegree.get(next) + 1);
            adjs.get(pre).add(next);
        }
    }

    static String[] solveByBFS(Map<String, Integer> indegree,  Map<String, List<String>> adjs) {
        String[] result = new String[indegree.size()];
        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            String from = queue.poll();
            result[visited++] = from;
            for (String to : adjs.get(from)) {
                indegree.put(to, indegree.get(to) - 1);
                if (indegree.get(to) == 0) queue.offer(to);
            }
        }
        return visited == indegree.size() ? result : new String[0];
    }

    public static void main(String[] args) {
        List<OrderDependency> list = new ArrayList<OrderDependency>();
        list.add(new OrderDependency("C", "D"));
        list.add(new OrderDependency("D", "A"));
        list.add(new OrderDependency("A", "B"));
        list.add(new OrderDependency("A", "E"));
        list.add(new OrderDependency("E", "B"));

        System.out.print(Arrays.toString(FindOrder.findOrder(list)));
    }
}