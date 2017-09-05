import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        int len = words[0].length();
        int index = 0;
        Map<Integer> 
        while (index < s.length() - len) {
            int i = index;
            while (i < s.length() - len && set.contains(s.substring(i, i + len))) {
                set.remove(s.substring(i, i + len));
                i = i + len;
            }
            if (set.size() == 0) {
                res.add(index);
            }
            index = i + len;
        }
        return res;
    }
}

// It's wrong I failed. Try to use a window and HashMap because it may have duplicates.