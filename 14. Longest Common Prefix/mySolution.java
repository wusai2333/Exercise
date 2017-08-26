class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int min = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(strs[i].length(), min);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length-1; j++) {
                if (strs[j].charAt(i) != strs[j+1].charAt(i)) return res.toString();
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}