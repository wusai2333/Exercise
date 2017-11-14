class Solution {
    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket: tickets) {
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        visit("JFK");
        return route;
    }

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();

    void visit(String from) {
        PriorityQueue<String> queue = targets.get(from);
        while (queue != null && !queue.isEmpty()) {
            visit(queue.poll());
        }
        route.addFirst(from);
    }
}