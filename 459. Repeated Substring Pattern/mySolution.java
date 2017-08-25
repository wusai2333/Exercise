class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i < len/2; i++) {
            if (len % i != 0) continue;
            int n = len / i;
            String candidate = s.substring(0, i);
            int j = i;
            while (j < n*i) {
                String sub1 = s.substring(j, j+i);
                if (!sub1.equals(candidate)) {
                    break;
                }
                j = j + i;
            }
            if (j == len) return true;
        }
        return false;
    }
}