public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arrays.get(0)) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int distance = 0;
        for (int i = 1; i < arrays.size(); i++) {
            int cur_max = Integer.MIN_VALUE;
            int cur_min = Integer.MAX_VALUE;
            for (int num: arrays.get(i)) {
                cur_max = Math.max(cur_max, num);
                cur_min = Math.min(cur_min, num);
            }
            distance = Math.max(Math.max(Math.abs(cur_max - min), Math.abs(max - cur_min)), distance);
            max = Math.max(max, cur_max);
            min = Math.min(min, cur_min);
        }
        return distance;
    }
}