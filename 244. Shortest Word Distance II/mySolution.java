import java.util.HashMap;
import java.util.Map;

public class WordDistance {
    public String[] words;
    public Map<String, Integer> pos;
    public WordDistance(String[] words) {
        this.words = words;
        pos = new HashMap<>();
    }
    
    public int shortest(String word1, String word2) {
        if (words == null) return -1;
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;//words.length();
        if (pos.containsKey(word1)) {
            p1 = pos.get(word1);
        }
        if (pos.containsKey(word2)) {
            p2 = pos.get(word2);
        }
        if (p1 == -1 && p2 == -1) {
            for (int i = 0; i < words.length; i++) {

                if (words[i].equals(word1)) {
                    p1 = i;
                    pos.put(word1, p1);
                }else if(words[i].equals(word2)) {
                    p2 = i;
                    pos.put(word2, p2);
                }
                if (p2 != -1 && p1 != -1) {
                    min = Math.min(min, Math.abs(p1 - p2));
                }
            }
        }
        return Math.min(min, Math.abs(p1 - p2));
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */