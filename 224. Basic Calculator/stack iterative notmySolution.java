class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int number = 0;
        int result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number += 10*number + Character.getNumericValue(c);
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') [
                result += sign * number;
                
            ]
        }
    }
}