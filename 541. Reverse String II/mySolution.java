public class Solution {
    public String reverseStr(String s, int k) {
        if (k == 0|| s == null || s.length() == 0) {return s;}
        char[] sa = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i = i + 2*k) {
            if (i + k > n) {
                reverse(sa, i, n);
                break;
            }
            reverse(sa, i, i + k);
        }
        return String.valueOf(sa);
    }
    private char[] reverse(char[] sa, int start, int end) { // Start(inclusive) end(exclusive)
        int s = start, e = end - 1;
        while (s < e) {
            char temp = sa[s];
            sa[s] = sa[e];
            sa[e] = temp;
            s++;
            e--;
        }
        return sa;
    }
}