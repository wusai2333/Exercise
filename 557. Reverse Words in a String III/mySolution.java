import java.util.Arrays;

public class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            ss[i] = reverse(ss[i]);
        }
        return String.join(" ", ss);
    }
    private String reverse(String a) {
        char[] aa = a.toCharArray();
        int s = 0, e = a.length()-1;
        while (s < e) {
            char temp = aa[s];
            aa[s++] = aa[e];
            aa[e--] = temp;
        }
        return String.valueOf(aa);
    }
}