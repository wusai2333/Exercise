import java.util.Stack;

class Solution {
    int rank(char op) {
        switch(op) {
            case '+' : return 1;
            case '-' : return 1;
            case '*' : return 2;
            case '/' : return 2;
            default  : return 0; // '(';
        }
    }
    List<Object> infixToPostfix(String s) {
        Stack<Character> operators = new Stack<>();
        List<Object> postfix = new LinkedList<Object>();

        int numberBuffer = 0;
        boolean bufferingOperand = false;
        for (char c: s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numberBuffer = numberBuffer*10 + c - '0';
                bufferingOperand = true;
            } else {
                if(bufferingOperand)
                    postfix.add(numberBuffer);
                numberBuffer = 0;
                bufferingOperand = false;

                if (c == ' ' || c == '\t')
                    continue;
                
                if (c == '(') {
                    operators.push('(');
                } else if (c == ')') {
                    while (operators.peek() != '(')
                        postfix.add(operators.pop());
                    operators.pop(); // pop the '(';
                } else { // operators
                    while (!operators.empty() && rank(c) <= operators.peek()) 
                        postfix.add(operators.pop());
                    operators.push(c);
                }
            }
        }
        if (bufferingOperand)
            postfix.add(numberBuffer);
        
        while (!operators.empty()) 
            postfix.add(operators.pop());
        
        return postfix;
    }

    int evaluatePostfix(List<Object> postfix) {
        Stack<Integer> operands = new Stack<>();
        int a = 0, b = 0;
        for (Object s : postfix) {
            if (s instanceof Character) {
                char c = (Character) s;
                b = operands.pop();
                a = operands.pop();
                switch (c) {
                    case '+': operands.push(a + b); break;
                    case '-': operands.push(a - b); break;
                    case '*': operands.push(a * b); break;
                    default : operands.push(a / b); break;
                }
            } else { // instanceof Integer
                operands.push((Integer)s);
            }
        }
        return operands.pop();
    }

    public int calculate(String s) {
        return evaluatePostfix(infixToPostfix(s));
    }
}