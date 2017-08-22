class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int minStart = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int j = i, k = i;
            while(k < s.length() - 1 && s.charAt(k+1) == s.charAt(k)) k += 1;
            while(j > 0 && k < s.length()-1 && s.charAt(j-1) == s.charAt(k+1)) {
                j -= 1;
                k += 1;
            }
            if (k - j + 1  > maxLen) {
                maxLen = k - j + 1;
                minStart = j;
            }
        }
        return s.substring(minStart, minStart+maxLen);
    }
}