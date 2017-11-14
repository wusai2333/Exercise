import java.util.Stack;
public class Valid2 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!stack.empty() && stack.peek() == '(') stack.pop();
                else return false;
            } else if (c == ']') {
                if (!stack.empty() && stack.peek() == '[') stack.pop();
                else return false;
            } else if (c == '}') {
                if (!stack.empty() && stack.peek() == '{') stack.pop();
                else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.print(Valid2.isValid(s));
    }
}