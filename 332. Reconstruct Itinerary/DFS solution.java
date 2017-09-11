class Solution {
    Map<String, PriorityQueue<String>> adjs;
    LinkedList<String> result;
    public List<String> findItinerary(String[][] tickets) {
        adjs = new HashMap<>();
        result = new LinkedList<>();
        for (String[] ticket: tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!adjs.containsKey(from)) {
                adjs.put(from, new PriorityQueue<>());
            }
            adjs.get(from).add(to);
        }
        
        dfs("JFK");
        return result;
    }

    private void dfs(String from) {
        PriorityQueue<String> queue = adjs.get(from);
        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll());
        }
        result.addFirst(from);
    }
}