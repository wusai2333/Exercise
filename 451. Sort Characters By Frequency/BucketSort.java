import java.util.ArrayList;
import java.util.Map;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            max = Math.max(max, map.get(c));
        }
        List<Character> [] bucket = new List[max+1];
        for (char key: map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.size() -1; pos > 0; pos--) {
             if (bucket[pos] != null) {
                 for (char c : bucket[pos]) {
                     for (int i = 0; i < pos; i++) {
                         sb.append(c);
                     }
                 }
             }
        }
        return sb.toString();
    }
}