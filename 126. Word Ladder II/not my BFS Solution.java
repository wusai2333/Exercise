import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    Map<String, List<String>> map;
    List<List<String>> results;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        results = new ArrayList<List<String>>();
        if (!wordSet.contains(endWord)) return results;
        int min = Integer.MAX_VALUE;
        Queue<String> toVisit = new ArrayDeque<>();
        toVisit.offer(beginWord);
        map = new HashMap<>();
        Map<String, Integer> ladder = new HashMap<String, Integer>();
        for (String word: wordSet) {
            ladder.put(word, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        // BFS: dijkstra serach
        while (!toVisit.isEmpty()) {
            String word = toVisit.poll();
            int step = ladder.get(word) + 1; //'step' indicates how many steps are needed to travel to one word
            if (step > min) break;
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char letter = array[i];
                for (char k = 'a'; k <= 'z'; k++) {
                    array[i] = k;
                    String newWord = String.valueOf(array);
                    if (wordSet.contains(newWord)) {
                        if (step > ladder.get(newWord)) // check if it is the shortest path to one word.
                            continue;
                        else if (step < ladder.get(newWord)) {
                            toVisit.offer(newWord);
                            ladder.put(newWord, step);
                        }

                        if (map.containsKey(newWord)) { // Build a adjcent graph
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new LinkedList<>();
                            list.add(word);
                            map.put(newWord, list);
                            // Or map.put(newWord, new LinkedList<String>(Arrays.asList(new String[]{word})));
                        }

                        if (newWord.equals(endWord)) {
                            min = step;
                        }
                    } // End if wordSet contains newWord;
                    array[i] = letter;
                } // End: Iteration from 'a' to 'z'
            } // End: Iteration from the first letter to the last;
        } // End while;
        // I don't understand why backtracking?
        List<String> result = new LinkedList<>();
        backTrace(endWord, beginWord, result);
        return results;

    }

    private void backTrace(String currWord, String beginWord, List<String> list) {
        if (currWord.equals(beginWord)) {
            list.add(0, currWord);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, currWord);
        if (map.get(currWord)!= null) {
            for (String s:map.get(currWord))
                backTrace(s, beginWord, list);
        }
        System.out.println(list.get(0));
        list.remove(0);

    }
}