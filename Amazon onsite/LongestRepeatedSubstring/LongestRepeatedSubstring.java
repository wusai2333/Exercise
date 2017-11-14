import java.util.Arrays;
public class LongestRepeatedSubstring {
    //return longest common prefix of s and t
    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }
    
    // return the longest repeated String in s.
    public static String LRS(String s) {
        // form N suffixes
        int n = s.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i, n);
        }

        Arrays.sort(suffixes);

        //find the longest repeated substring by comparing adjacent sorted suffixes.
        String lrs = "";
        for (int i = 0; i < n - 1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            if (x.length() > lrs.length()) {
                lrs = x;
            }
        }
        return lrs;
    }

    public static void main(String[] args) {
        String s = "banana";
        System.out.print("'" + LRS(s) +"'");    
    }
}