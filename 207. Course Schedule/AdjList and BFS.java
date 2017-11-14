class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int[] arr: prerequisites) {
            adjList.putIfAbsent(arr[0], new ArrayList<>());
            adjList.putIfAbsent(arr[1], new ArrayList<>());
            indegree.putIfAbsent(arr[1], 0);
            indegree.putIfAbsent(arr[0], 0);
            adjList.get(arr[1]).add(arr[0]);
            indegree.put(arr[0], indegree.get(arr[0]) + 1);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int key: indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            int from = queue.poll();
            res.add(from);
            for (int to : adjList.get(from)) {
                indegree.put(to, indegree.get(to) - 1);
                if (indegree.get(to) == 0) queue.offer(to);
            }
        }
        return res.size() == indegree.size();
    }
}