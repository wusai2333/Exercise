class Solution {
    public int findSubstringInWraproundString(String p) {
        int maxLength = 1;
        int[] count = new int[26];
        for (int i = 0; i < p.length();i++) {
            if (i > 0 && (p.charAt(i-1) + 1 == p.charAt(i) || p.charAt(i-1) == 'z' && p.charAt(i) == 'a')) {
                maxLength ++;
            } else {
                maxLength = 1;
            }

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLength);
        }

        int sum = 0;
        for (int i : count) {
            sum += i;
        }
        return sum;
    }
}