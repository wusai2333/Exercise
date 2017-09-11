class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> adjs = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (String[] ticket: tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!adjs.containsKey(from)) {
                adjs.put(from, new ArrayList<>());
                indegree.put(from, 0);
            }
            if (!adjs.containsKey(to)) {
                adjs.put(to, new ArrayList<>());
                indegree.put(to, 0);
            }
            adjs.get(from).add(to);
            indegree.put(to, indegree.get(to) + 1);
        }

        Queue<String> queue = new ArrayDeque<>();
        if (indegree.get("JFK") != 0) {
            queue.offer("JFK");
        }
        for (String s : indegree.keySet()) {
            if (indegree.get(s) == 0) {
                queue.offer(s);
            }
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String from = queue.poll();
            res.add(from);
            for(String to : adjs.get(from)) {
                indegree.put(to, indegree.get(to) - 1);
                if (indegree.get(to) == 0) {
                    queue.offer(to);
                }
            }
        }
        return res;
    }
}