import java.util.LinkedList;
import java.util.Set;
// This solution gets a stackOverFlow error;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet);
    }

    private List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new LinkedList<>();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            String last = s.substring(i, len);
            if (wordDict.contains(last)) {
                if (i == 0) {
                    res.add(last);
                } else {
                    String remain = s.substring(0, i);
                    List<String> remainList = wordBreak(s, wordDict);
                    if (remainList != null) {
                        for (String item: remainList) {
                            res.add(item + " " + last);
                        }
                    }
                }
            }
        }
        return res;
    }
}