import java.util.*;
class Solution {
    /** travel all the words combination to maintain a window
     * there are wl(word len) times travel.
     * each time, n/wl words, mostly 2 times travel for each word.
     * one left side of the window, the other right side of the window
     * so time complexity is O(wl * 2 * N / wl) = O(2N);
     */
    public List<Integer>  findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (words.length == 0 || s == null || s.length() < words.length * words[0].length())
            return res;
        int N = s.length(), M = words.length, K = words[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String str = null, tmp = null;
        for (int i = 0; i < K; i++) {
            int count = 0;
            for (int l = i, r = i; r + K <= N; r += K) {
                str = s.substring(r, r + K);
                if (map.containsKey(str)) {
                    curMap.put(str, curMap.getOrDefault(str, 0) + 1);

                    if (curMap.get(str) <= map.get(str)) count ++;
                    while (curMap.get(str) > map.get(str)) {
                        tmp = s.substring(l, l + K);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += K;
                        if (curMap.get(tmp) < map.get(tmp)) count--;
                    }
                    if (count == M) {
                        res.add(l);
                        tmp = s.substring(l, l + K);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += K;
                        count--;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    l = r + K;
                }
            }
            curMap.clear();
        }
        return res;
    }
}