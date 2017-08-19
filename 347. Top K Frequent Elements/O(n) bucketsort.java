import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<Integer>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length-1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}