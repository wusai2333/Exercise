import java.util.Queue;
import java.util.Set;

/** Wrong in java, but it is right in C++, because C++ has reference */
/** Below is the  */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        level.offer(1);
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            String word = queue.poll();
            int l = level.poll();
            if (word.equals(endWord)) return l;
            char[] neighbors = word.toCharArray();
            for (int j = 0; j < beginWord.length(); j++) {
                char old = neighbors[j];
                for (char c = 'a'; c <= 'z'; c++) {
                    neighbors[j] = c;
                    String newWord = String.valueOf(neighbors);
                    if (dic.contains(newWord)) {
                        queue.offer(newWord);
                        level.offer(l+1);
                        dic.remove(newWord);
                    }
                }
                neighbors[j] = old;
            }
        }
        return 0;
    }
}