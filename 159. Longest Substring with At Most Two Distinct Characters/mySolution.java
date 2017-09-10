class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int count = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; ) {
            int temp = 0;
            count = 0;
            char[] twoChars = new char[2];
            int[] idxs = new int[2];
            for (int j = i; j < s.length(); j++) {
                if (count == 0 || count == 1 && s.charAt(j) != twoChars[0]) {
                    twoChars[count] = s.charAt(j);
                    idxs[count++] = j;
                }
                if (count == 2 && s.charAt(j) != twoChars[0] && s.charAt(j) != twoChars[1]) {
                    maxLen = Math.max(j - i + 1, maxLen);
                    i = j;
                    break;
                }
            }
        }
        return maxLen;
    }
}