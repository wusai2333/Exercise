public class LongestPalindromicString {
    public static String longestPalindromicString(String s) {
        if (s.length() < 2) return s;
        int start = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int j = i, k = i;
            while (k < s.length() - 1 && s.charAt(k + 1) == s.charAt(k)) k++;
            while (j > 0 && k < s.length() - 1 && s.charAt(j-1) == s.charAt(k+1)) {
                k++;
                j--;
            }
            if (k - j + 1 > maxLen) {
                maxLen = k - j + 1;
                start  = j;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babacasdfdfsafsdfgdeggrgsdfaerdaf";
        String s2 = "abcdefg";
        System.out.print(LongestPalindromicString.longestPalindromicString(s2));
    }
}