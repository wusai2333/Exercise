class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(child);
        }

        if (map.get(0).get(0) == kill) return pid;

        List<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int process = queue.poll();
            res.add(process);
            List<Integer> children = map.get(process);
            if (children == null) continue;
            queue.addAll(children);
        }
        return res;
    }
}