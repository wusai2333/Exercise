class Solution {
    public boolean checkRecord(String s) {
        int countL  = 0, countA = 0;
        int n = s.length();
        for (int i = 0; i < n;) {
            while(s.charAt(i) == 'L') {
                countL++;
                i++;
            }
            if (countL > 2) return false;
            countL = 0;
            if (s.charAt(i) == 'A') {
                countA ++;
            }
            if (countA > 1) return false;
            i++;
        }
        return true;
    }
}