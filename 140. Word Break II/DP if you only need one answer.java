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
        List<Integer>[] dp = new List[s.length()+1];
        dp[0] = new LinkedList<Integer>();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != null && wordDict.contains(s.substring(j, i))) {
                    List<Integer> list = new LinkedList<>(dp[j]);
                    list.add(j);
                    if (i == s.length()) {
                        list.add(s.length());
                    }
                    dp[i] = list;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < dp[s.length()].size(); i++) {
            res.append(" "+s.substring(dp[s.length()].get(i-1), dp[s.length()].get(i)));
        }
        
        List<String> result = new LinkedList<>();
        result.add(res.toString().trim());
        return result;
    }
}