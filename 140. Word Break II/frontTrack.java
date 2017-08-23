import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    Map<String, List<String>> results = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet);
    }

    private List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new LinkedList<>();
        int len = s.length();
        for (int i = 1; i <= len; i++) {
            String front = s.substring(0, i);
            if (wordDict.contains(front)) {
                if (i == len) {
                    res.add(front);
                } else {
                    String remain = s.substring(i);
                    List<String> remainList = results.containsKey(remain)? results.get(remain): wordBreak(remain, wordDict);
                    if (remainList != null) {
                        for (String item: remainList) {
                            res.add(front + " " + item);
                        }
                        results.put(remain, remainList);
                    }
                }
            }
        }
        return res;
    }
}