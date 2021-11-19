import java.util.Stack;

public class Calculator {
    public static String ExpressionToRPN(String expression) {
        String current = "";
        Stack<Character> stack = new Stack<>();

        int priority;
        for (int i = 0; i < expression.length(); i++) {
            priority = getPriority(expression.charAt(i));

            if (priority == 0) current += expression.charAt(i);

            if (priority > 0) {
                current += ' ';

                while (!stack.isEmpty()) {
                    if (getPriority(stack.peek()) >= priority) current += stack.pop();
                    else break;
                }
                stack.push(expression.charAt(i));
            }
        }
        while (!stack.isEmpty()) current += stack.pop();
        return current;
    }

    public static int RPNtoAnswer(String rpn) {
        String operand = new String();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') continue;

            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()) break;
                }
                stack.push(Integer.parseInt(operand));
                operand = new String();
            }
            if (getPriority(rpn.charAt(i)) > 0) {
                int a = stack.pop();
                int b = stack.pop();

                switch (rpn.charAt(i)) {
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private static int getPriority(char token) {
        if (token == '*' || token == '/') return 2;
        else if (token == '+' || token == '-') return 1;
        else return 0;
    }
}
