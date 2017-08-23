import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;
        //step1. reverse the whole string
        reverse(a, 0, n - 1);
        //step2.reverse each word
        reverseWord(a, n);
        //step3.cleanspace
        return cleanSpace(a, n);
    }

    private String cleanSpace(char[] a, int len) {
        int i = 0, j = 0;
        while (j < len) {
            while (j < len && a[j] == ' ') j++;
            while (j < len && a[j] != ' ') a[i++] = a[j++];
            while (j < len && a[j] == ' ') j++;
            if (j < len) a[i++] = ' ';
        }
        return String.valueOf(a).substring(0, i);
    }
    private void reverseWord(char[] a, int len) {
        int i = 0, j = 0;
        while (i < len) {
            while(i < j || i < len && a[i] == ' ') i ++;
            while(j < i || j < len && a[j] != ' ') j ++;
            reverse(a, i, j-1);
        }
    }
    private void reverse(char[] a, int start, int end) {
        while (start < end) {
            char temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }
}