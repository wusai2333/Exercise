import java.util.HashMap;
import java.util.Map;

public class WordDistance {
    public Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i ++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                map.put(words[i], new ArrayList<Integer>(Arrays.asList(i)));
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> p1s = map.get(word1);
        List<Integer> p2s = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int p1 : p1s) {
            for (int p2: p2s) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */