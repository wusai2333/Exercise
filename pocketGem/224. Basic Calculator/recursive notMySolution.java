/**
 * Each invocation of evaluate() evaluates whatever inside a pair of parenthese. Nested parenthese will be handled by recursive calls.

So "(1+(4+5+2)-3)+(6+8)"

->

(1+(9+2)-3)+(6+8)

->

(1+11-3)+(6+8)

->

(12-3)+(6+8)

->

9+(6+8)

->

9+14

->

23
 */

class Solution {
    int pos = 0;
    public int calculate(String s) {
        return evaluate(s);
    }

    private int evaluate(String s) {
        int res = 0;
        int sign = 1;
        while (pos < s.length() && s.charAt(pos) != ')') {
            if (s.charAt(pos) == '+' || s.charAt(pos) == ' ') 
                pos++;
            else if (s.charAt(pos) == '-') {
                pos++;
                sign = -1;
            } else if (s.charAt(pos) == '(') {
                pos++;
                res += sign * evaluate(s);
                sign = 1;
            } else {
                int num = 0;
                while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                    num = 10 * num + (int)Character.getNumericValue(s.charAt(pos++));
                }
                res += sign * num;
                sign = 1;
            }
        }
        pos ++; //skip the current ')'
        return res;
    }
}