import java.util.Map;
import java.util.Map.Entry;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Pair<Integer, Integer>> preSum = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        preSum.put(0, new Pair(1, -1));

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                int count = preSum.get(sum - k).first;
                int index = preSum.get(sum - k).second;
                result += count;
                map.put(index+1, i);
            }
            if (preSum.containsKey(sum)) {
                preSum.put(sum, new Pair(preSum.get(sum).first+1, i));
            } else {
                preSum.put(sum, new Pair(1, i));
            }
        }
        for (Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.println("("+entry.getKey() + " " + entry.getValue()+")");
        }
        return result;
    }
}
class Pair<F, S> {
    F first;
    S second;
    Pair (F first, S second) {
        this.first = first;
        this.second  = second;
    }
}
