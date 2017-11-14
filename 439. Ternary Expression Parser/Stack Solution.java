class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.isEmpty()) return "";
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.empty() && stack.peek() == '?') {
                stack.pop();
                char first = stack.pop();
                stack.pop();
                char second = stack.pop();
                if (c == 'T') {
                    stack.push(first);
                } else if (c == 'F') {
                    stack.push(second);
                }
            } else {
                stack.push(c);
            }
        }
        return Character.toString(stack.pop());
    }
}