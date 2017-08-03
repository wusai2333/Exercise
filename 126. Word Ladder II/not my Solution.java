import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    List<List<String>> results;
    Map<String, List<String>> map;
    List<String> list;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<List<String>>();
        int curr = 1, next = 0;
        boolean found = false;
        list = new LinkedList<String>();
        map = new HashMap<String, List<String>>();
        Queue<String> queue = new ArrayDeque<String>();
        Set<String> unvisited = new HashSet<>(wordList);
        if (!unvisited.contains(endWord)) return false;
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        unvisited.remove(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    builder.setCharAt(i, c);
                    String newWord = builder.toString();
                    if (unvisited.contains(newWord)) {
                        //Handle queue
                        if (visited.add(newWord)) { // Avoid Duplicate insertion
                            next++;
                            queue.add(newWord);
                        }

                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> l = new LinkedList<>();
                            l.add(word);
                            map.put(newWord, l);
                        }

                        if (newWord.equals(endWord) && !found) found = true;
                    }
                } // End: iteration from 'a' to 'z';
            } // End: iteration from first char to the last
            if (curr == 0) {
                if (found) break;
                curr = next;
                next = 0;
                unvisited.removeAll(visited);
                visited.clear(); 
            }
        }
        backTrace(endWord, beginWord);
        return results;

    }

    public void backTrace(String word, String beginWord) {
        if (word.equals(beginWord)) {
            list.add(0, beginWord);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word) != null) {
            for (String s: map.get(word)) {
                backTrack(s, beginWord);
            }
        }
        list.remove(0);
    }
}