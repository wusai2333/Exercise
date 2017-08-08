public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null) return num2;
        if (num2 == null) return num1;

        int m = num1.length(), n = num2.length();
        int[] digits = new int[m+n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                int multi = (num2.charAt(i) - '0')*(num1.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = multi + digits[p2];
                digits[p2] = sum % 10;
                digits[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p: digits) if (!(sb.length()==0 && p==0)) sb.append(p);
        return sb.length() == 0? "0" : sb.toString();
    }
}