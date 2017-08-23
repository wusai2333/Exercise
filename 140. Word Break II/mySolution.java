import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return DFS(s, wordSet, new HashMap<String, LinkedList<String>>());
    }

    private List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word: wordDict) { // The wordDict maybe large so it may not be efficient.
            if (s.startsWith(word)) {
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
                for (String sub: subList) 
                    res.add(word + (sub.isEmpty()? "": " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}