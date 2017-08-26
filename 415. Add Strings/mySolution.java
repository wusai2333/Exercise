class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length()-1, m = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= 0 || m >= 0 || carry > 0) {
            int val1 = 0, val2 = 0;
            if (n >= 0) {
                val1 = num1.charAt(n) - '0';
                n--;
            }
            if (m >= 0) {
                val2 = num2.charAt(m) - '0';
                m--;
            }
            int sum = val1 + val2 + carry;
            sb.insert(0, sum%10);
            carry = sum/10;
        }
        return sb.toString();
    }
}