class Solution {
    public String countAndSay(int n) {
        String s = "1";
        StringBuilder temp = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            temp.delete(0, temp.length());
            int count = 0;
            char letter = '0';
            for (int j = 0; j <= s.length(); j++) {
                if (j == s.length() || letter != s.charAt(j)) {
                    if (count > 0) {
                        temp.append(count).append(letter);
                        count = 0;
                    }
                    if (j != s.length()) {
                        letter = s.charAt(j);
                    }
                }
                count ++;
            }
            s = temp.toString();
        }
        return s;
    }
}