class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()+1];
        boolean[][] pal = new boolean[s.length()+1][s.length()+1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = i-1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j))
            }
        }
        return dp[s.length()];
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

res.stream().mapToInt(i->i).toArray();