class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[128];
        int max = 0;
        int start = 0;
        for (int end = 0; end < len; end++) {
            max = Math.max(max, ++count[s.charAt(end)]);
            if (max + k <= end - start) {
                count[s.charAt(start++)]--;
            }
        }
        return s.length() - start;
    }
}