class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return 0;
        int[] next = new int[m];
        getNext(needle, next);
        while (i < n && j < m) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j == m) {
            return i - j;
        } else {
            return -1;
        }
    }

    private void getNext(String needle, int[] next) {
        int len = needle.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }
}