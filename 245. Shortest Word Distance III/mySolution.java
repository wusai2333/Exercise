import java.util.List;

import java.util.HashMap;

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < words.length; i ++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                map.put(words[i], new ArrayList<Integer>(Arrays.asList(i)));
            }
        }

        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            List<Integer> list = map.get(word1);
            for (int i = 0; i < list.size()-1; i++) {
                min = Math.min(list.get(i+1) - list.get(i), min);
            }
            return min;
        } else {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            for (int p1: list1) {
                for (int p2: list2) {
                    min = Math.min(Math.abs(p1 - p2), min);
                }
            }
            return min;
        }
    }
}