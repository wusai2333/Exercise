class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int index = s.length()-1;
        for (; index >= 0; index--) {
            if(isPalindrome(s, 0, index)) break;
        }
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sub = new StringBuilder(s.substring(index + 1, s.length())).reverse();
        sb.insert(0, sub);
        return sb.toString();
    }
    private boolean isPalindrome(String s, int i, int j) {
        int start = i, end = j;
        while (start  < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}