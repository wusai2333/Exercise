import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        wordSet.add(beginWord);
        Queue<String> toVisit = new LinkedList<>();
        addNextWord(beginWord, wordSet, toVisit);
        int dist = 2;
        while (!toVisit.isEmpty()) {
            int num = toVisit.size();
            for (int i = 0; i < num; i++) {
                String word = toVisit.poll();
                if (word.equals(endWord)) return dist;
                addNextWord(word, wordSet, toVisit);
            }
            dist ++;
        }
        return 0;
    }

    private void addNextWord (String word, Set<String> wordSet, Queue<String> toVisit) {
        wordSet.remove(word);
        char[] array = word.toCharArray();
        for (int p = 0; p < array.length; p++) {
            char letter = array[p];
            for (char k = 'a'; k <= 'z'; k ++) {
                array[p] = k;
                String newWord = String.valueOf(array);
                if (wordSet.contains(newWord)) {
                    toVisit.offer(newWord);
                    wordSet.remove(newWord);
                }
            }
            array[p] = letter;
        }
    }
}