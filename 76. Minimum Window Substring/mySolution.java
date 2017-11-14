class Solution {
    public String minWindow(String s, String t) {
        int[] table = new int[256];
        
        for (int c : t.toCharArray()) {
            table[c]++; // work as an Map
        }
        int d = Integer.MAX_VALUE, start = 0; // d is the length of the longest entry.
        int counter = t.length(), begin = 0, end = 0;
        while (end < s.length()) {
            // if this character is in stirng t, map count minus one, counter minus one;
            if (table[s.charAt(end++)]-- > 0) counter--; 
            
            while (counter==0) { // when it is valid
                if (end - begin < d) { // shorter than the older max
                    d = end - begin; // update the new length;
                    start = begin; // update the start index;
                }
                if (table[s.charAt(begin++)]++ == 0) counter++; // advance the begin index, if losing this character make the substring invalid, counter plus one.
            }
        }
        return d == Integer.MAX_VALUE? "" : s.substring(start, start + d); // if there is no valid substring, return "";
    }
}