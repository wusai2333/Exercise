class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dict = new int[256];

        int start = 0, len = 1, count = 0;
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i)] ++;
            if (dict[s.charAt(i)] == 1) { // new char++;
                count++;
                while (count > 2) {
                    dict[s.charAt(start)]--;
                    if (dict[s.charAt(start)] == 0) count--;
                    start ++;
                }
            }
            if (i - start + 1 > len) len = i - start + 1;
        }
        return len;
    }
}
/**
 * This kind of question always need a hashTable and two pointers :
 * longest substring without reapeating characters, 
 * minimum window substring,
 * substring with concatenation of all words.
 */