public class Solution {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return ways(s.charAt(0));
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for (int j = 2; j < s.length(); j++) {
            long temp = res[1];
            res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) % 1000000007;
            res[0] = temp;
        }
        return (int)res[1];
    }

    private static int ways(char ch) {
        if (ch == '*') return 9;
        if (ch == '0') return 0;
        return 1;
    }

    private static int ways(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if (ch1 != '*' && ch2 != '*') {
            if (Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26) 
                return 1;
        } else if (ch1 == '*' && ch2 == '*') {
            return 15;
        } else if (ch1 == '*') {
            if (Character.getNumericValue(ch2) >= 0 && Character.getNumericValue(ch2) <= 6)
                return 2;
            else return 1;   
        } else {
            if (Character.getNumericValue(ch1) == 1) {
                return 9;
            } else if (Character.getNumericValue(ch1) == 2) {
                return 6;
            }
        }
        return 0;
    }
}