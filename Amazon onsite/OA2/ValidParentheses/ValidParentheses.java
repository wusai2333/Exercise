import java.util.Stack;
public class ValidParentheses {
    public static int isValid(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Character> stack = new Stack<>();
        int count  = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')' && !stack.empty()) {
                stack.pop();
                count ++;
            } else {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "(())(())(())(())((()))()()()()";
        System.out.print(ValidParentheses.isValid(s));
    }
}