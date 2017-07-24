public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0) {return b;}
        int p1 = a.length()-1;
        int p2 = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 >= 0 || p2 >= 0 || carry > 0) {
            int x = 0, y = 0;
            if (p1 >= 0) {
                 x = Character.getNumericValue(a.charAt(p1));
            }
            if (p2 >= 0) {
                 y = Character.getNumericValue(b.charAt(p2));
            }
            int res = (x + y + carry) % 2;
            carry = (x + y + carry) /2;
            sb.insert(0, (char)(res + '0'));
            p1 --;
            p2 --;
        }
        return sb.toString();
    }
}